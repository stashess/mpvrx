package com.test.mpv_rx.utils;

import com.test.mpv_rx.fragment.Fragment1;
import com.test.mpv_rx.fragment.Fragment2;
import com.test.mpv_rx.fragment.Fragment3;
import com.test.mpv_rx.fragment.OcrCaptureFragment;

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

    public static final class Fragment3Screen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new Fragment3();
        }
    }

    public static final class FragmentOcr extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new OcrCaptureFragment();
        }
    }
}
