package com.android.animation.sunset;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tony on 8/17/16.
 */
public class SunsetFragment extends Fragment {

    private View mSceneView;
    private View mSunView;
    private View mSkyView;

    public static SunsetFragment newInstance(){
        return new SunsetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunset, container, false);

        mSceneView = view;
        mSkyView = view.findViewById(R.id.sky);
        mSunView = view.findViewById(R.id.sun);

        mSceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });
        return view;
    }

    public void startAnimation(){
        float sunYStart = mSunView.getTop();
        float sunYEnd = mSunView.getHeight();

        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(
                mSunView,
                "y",
                sunYStart,
                sunYEnd)
                    .setDuration(3000);
        heightAnimator.start();
    }
}
