package com.ms.view.loading.page;

import android.app.Activity;
import android.view.ViewGroup;

public interface IInterPageStatus extends IPageStatus{

    void init(ViewGroup viewGroup);

    void init(Activity viewGroup);

    void setLoadingColor(int color);
}
