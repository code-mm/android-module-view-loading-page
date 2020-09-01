package com.ms.view.loading.page;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class PagesStatusImpl implements IInterPageStatus {

    // 加载中
    private RelativeLayout statusRelativeLayoutLoading;
    // 空
    private RelativeLayout statusRelativeLayoutEmpty;
    // 错误
    private RelativeLayout statusRelativeLayoutError;
    // 无网络
    private RelativeLayout statusRelativeLayoutNotNetwork;


    private ProgressBar progressBarLoading;

    private Drawable drawableProgressBarLoading;

    private Drawable wrappedDrawable;

    private int drawableProgressBarLoadingId = R.drawable.com_ms_app_dialog_loading;

    private int progressBarLoadingColor = Color.parseColor("#000000");

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


        progressBarLoading = context.findViewById(R.id.progressBarLoading);

        drawableProgressBarLoading = ContextCompat.getDrawable(context, drawableProgressBarLoadingId).mutate();
        wrappedDrawable = DrawableCompat.wrap(drawableProgressBarLoading);
        wrappedDrawable.setTint(progressBarLoadingColor);
        progressBarLoading.setIndeterminateDrawable(drawableProgressBarLoading);

        hideAllStatus();
    }

    @Override
    public void setLoadingColor(int color) {
        this.progressBarLoadingColor = color;
        wrappedDrawable.setTint(progressBarLoadingColor);
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
        if (statusRelativeLayoutLoading != null) {
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
