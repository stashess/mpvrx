package com.test.mpv_rx.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.test.mpv_rx.R;
import com.test.mpv_rx.RxApp;
import com.test.mpv_rx.utils.Screens;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation_view)
    BottomNavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    Router mRouter;

    NavigatorHolder mNavigatorHolder;

    Navigator mNavigator = new SupportAppNavigator(this, R.id.content_frame);

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
        Toast test = Toast.makeText(this, "test", Toast.LENGTH_SHORT);
        test.show();
        mNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.f1) {
                mRouter.navigateTo(new Screens.Fragment1Screen());
            } else if (menuItem.getItemId() == R.id.f2) {
                mRouter.navigateTo(new Screens.Fragment2Screen());
            } else if (menuItem.getItemId() == R.id.f3) {
                mRouter.navigateTo(new Screens.Fragment3Screen());
            }
            return true;
        });

        mRouter.newRootScreen(new Screens.Fragment2Screen());
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

    public Toolbar getToolbar() {
        return mToolbar;
    }
}
