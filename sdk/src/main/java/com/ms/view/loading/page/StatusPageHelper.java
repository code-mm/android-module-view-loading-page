package com.ms.view.loading.page;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;

public class StatusPageHelper implements IPageStatus, IInterPageStatus {

    private static final String TAG = "StatusPageHelper";

    IInterPageStatus statusPage;

    @Override
    public void init(ViewGroup viewGroup) {
        try {
            Class<?> aClass = Class.forName("com.ms.view.loading.page.PagesStatusImpl");
            Object o = aClass.newInstance();
            if (o instanceof IInterPageStatus) {
                statusPage = (IInterPageStatus) o;
                statusPage.init(viewGroup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(Activity activity) {
        try {
            Class<?> aClass = Class.forName("com.ms.view.loading.page.PagesStatusImpl");
            Object o = aClass.newInstance();
            if (o instanceof IInterPageStatus) {
                statusPage = (IInterPageStatus) o;
                statusPage.init(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setLoadingColor(int color) {
        if (statusPage != null) {
            statusPage.setLoadingColor(color);
        }
    }


    public void hideAllStatus() {
        if (statusPage != null) {
            statusPage.hideAllStatus();
        }
    }


    public void showLoading() {
        Log.e(TAG, "showLoading: ");
        if (statusPage != null) {
            Log.e(TAG, "showLoading: 1");
            statusPage.showLoading();
        }
    }


    public void showNotNetwork() {
        if (statusPage != null) {
            statusPage.showNotNetwork();
        }
    }

    public void showEmpty() {
        if (statusPage != null) {
            statusPage.showEmpty();
        }
    }

    public void showError() {
        if (statusPage != null) {
            statusPage.showError();
        }
    }
}