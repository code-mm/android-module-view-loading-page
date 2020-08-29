package com.ms.view.loading.page;

import android.app.Activity;
import android.util.Log;

public class StatusPageHelper  implements  IPageStatus {


    private static final String TAG = "StatusPageHelper";

    private static final StatusPageHelper instance = new StatusPageHelper();

    public static StatusPageHelper getInstance() {
        return instance;
    }

    IInterPageStatus statusPage;

    public void init(Activity activity) {
        try {
            Class<?> aClass = Class.forName("com.ms.view.loading.page.PagesStatusImpl");
            Object o = aClass.newInstance();
            if (o instanceof IInterPageStatus) {
                statusPage = (IInterPageStatus) o;
                statusPage.view(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void hideAllStatus() {
        if(statusPage!=null)
        {
            statusPage.hideAllStatus();
        }
    }


    public void showLoading() {
        Log.e(TAG, "showLoading: " );
        if(statusPage!=null)
        {
            Log.e(TAG, "showLoading: 1" );
            statusPage.showLoading();
        }
    }


    public void showNotNetwork() {
        if(statusPage!=null)
        {
            statusPage.showNotNetwork();
        }
    }

    public void showEmpty() {
        if(statusPage!=null)
        {
            statusPage.showEmpty();
        }
    }
    public void showError() {
        if(statusPage!=null)
        {
            statusPage.showError();
        }
    }
}
