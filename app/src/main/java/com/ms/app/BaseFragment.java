package com.ms.app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ms.view.loading.page.StatusPageHelper;

public class BaseFragment extends Fragment {

    protected View view;
    private StatusPageHelper statusPageHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getLayoutId() != 0) {
            View view = inflater.inflate(getLayoutId(), container, true);
            statusPageHelper = new StatusPageHelper();
            View rootView = view.getRootView();
            if (rootView instanceof ViewGroup) {
                statusPageHelper.init((ViewGroup) rootView);
                statusPageHelper.setLoadingColor(Color.parseColor("#fff000"));
            }
            this.view = view;
            initView();
        }
        return view;
    }

    protected void initView() {

    }

    public void showLoading() {
        if (statusPageHelper != null) {
            statusPageHelper.showLoading();
        }
    }

    public void hideAllStatus() {
        if (statusPageHelper != null) {
            statusPageHelper.hideAllStatus();
        }
    }

    protected int getLayoutId() {
        return 0;
    }
}
