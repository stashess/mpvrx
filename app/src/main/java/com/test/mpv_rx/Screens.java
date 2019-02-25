package com.test.mpv_rx;

import com.test.mpv_rx.fragment.Fragment1;
import com.test.mpv_rx.fragment.Fragment2;
import com.test.mpv_rx.fragment.HelloFragment;

import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class Fragment1Screen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new Fragment1();
        }
    }

    public static final class Fragment2Screen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new Fragment2();
        }
    }

    public static final class FragmentHelloScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new HelloFragment();
        }
    }
}
