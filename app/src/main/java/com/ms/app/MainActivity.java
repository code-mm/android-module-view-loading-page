package com.ms.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.ms.view.loading.page.StatusPageHelper;


public class MainActivity extends AppCompatActivity {


    private StatusPageHelper statusPageHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusPageHelper = new StatusPageHelper();
        statusPageHelper.init(this);
        statusPageHelper.setLoadingColor(Color.parseColor("#F58533"));


    }

    public void hideAll(View view) {
        statusPageHelper.hideAllStatus();
    }

    public void showLoading(View view) {
        statusPageHelper.showLoading();
    }

    public void showNotNetwork(View view) {
        statusPageHelper.showNotNetwork();
    }

    public void showError(View view) {
        statusPageHelper.showError();
    }

    public void showEmpty(View view) {
        statusPageHelper.showEmpty();
    }
}