package com.test.mpv_rx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    Router mRouter;

    NavigatorHolder mNavigatorHolder;

    Navigator mNavigator = new SupportAppNavigator(this,R.id.content_frame);

    @Override
    protected void onPause() {
        mNavigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mNavigatorHolder.setNavigator(mNavigator);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mRouter = RxApp.INSTANCE.getRouter();
        mNavigatorHolder = RxApp.INSTANCE.getNavigationHolder();

        mNavigationView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.f1){
              mRouter.navigateTo(new Screens.Fragment1Screen());
            } else if (menuItem.getItemId() == R.id.f2){
                mRouter.navigateTo(new Screens.Fragment2Screen());
            }

            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        mRouter.newRootScreen(new Screens.FragmentHelloScreen());

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
