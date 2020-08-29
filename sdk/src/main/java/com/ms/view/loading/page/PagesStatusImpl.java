package com.ms.view.loading.page;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class PagesStatusImpl implements IInterPageStatus {

    // 加载中
    private RelativeLayout statusRelativeLayoutLoading;
    // 空
    private RelativeLayout statusRelativeLayoutEmpty;
    // 错误
    private RelativeLayout statusRelativeLayoutError;
    // 无网络
    private RelativeLayout statusRelativeLayoutNotNetwork;


    @Override
    public void view(Activity context) {
        if (context == null) {
            throw new NullPointerException("context null");
        }
        View view = View.inflate(context, R.layout.com_ms_status_all_layout, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        context.addContentView(view, layoutParams);

        statusRelativeLayoutLoading = (RelativeLayout) context.findViewById(R.id.statusRelativeLayoutLoading);
        statusRelativeLayoutEmpty = (RelativeLayout) context.findViewById(R.id.statusRelativeLayoutEmpty);
        statusRelativeLayoutError = (RelativeLayout) context.findViewById(R.id.statusRelativeLayoutError);
        statusRelativeLayoutNotNetwork = (RelativeLayout) context.findViewById(R.id.statusRelativeLayoutNotNetwork);

        hideAllStatus();
    }

    @Override
    public void hideAllStatus() {
        if (statusRelativeLayoutLoading != null) {
            statusRelativeLayoutLoading.setVisibility(View.GONE);
        }
        if (statusRelativeLayoutEmpty != null) {
            statusRelativeLayoutEmpty.setVisibility(View.GONE);
        }
        if (statusRelativeLayoutError != null) {
            statusRelativeLayoutError.setVisibility(View.GONE);
        }
        if (statusRelativeLayoutNotNetwork != null) {
            statusRelativeLayoutNotNetwork.setVisibility(View.GONE);
        }
    }

    private static final String TAG = "StatusPages";

    @Override
    public void showLoading() {
        hideAllStatus();
        Log.e(TAG, "showLoading: 0");
        if (statusRelativeLayoutLoading != null) {
            Log.e(TAG, "showLoading: 1");
            statusRelativeLayoutLoading.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showNotNetwork() {
        hideAllStatus();
        if (statusRelativeLayoutNotNetwork != null) {
            statusRelativeLayoutNotNetwork.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showEmpty() {
        hideAllStatus();
        if (statusRelativeLayoutEmpty != null) {
            statusRelativeLayoutEmpty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError() {
        hideAllStatus();
        if (statusRelativeLayoutError != null) {
            statusRelativeLayoutError.setVisibility(View.VISIBLE);
        }
    }
}
