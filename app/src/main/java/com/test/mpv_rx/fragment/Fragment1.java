package com.test.mpv_rx.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.test.mpv_rx.R;
import com.test.mpv_rx.utils.Screens;

import javax.inject.Inject;

public class Fragment1 extends AbstractFragment {

    @Inject
    Router router;

    @Override
    protected String getToolbarName() {
        return "Fragment1";
    }

    @BindView(R.id.open_camera)
    MaterialButton materialButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        materialButton.setOnClickListener(v -> router.navigateTo(new Screens.FragmentOcr()));
    }


}
