package com.ms.view.loading.page;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusPageHelper.getInstance().view(this);
        StatusPageHelper.getInstance().setLoadingColor(Color.parseColor("#F58533"));
    }

    public void hideAll(View view) {
        StatusPageHelper.getInstance().hideAllStatus();
    }

    public void showLoading(View view) {
        StatusPageHelper.getInstance().showLoading();
    }

    public void showNotNetwork(View view) {
        StatusPageHelper.getInstance().showNotNetwork();
    }

    public void showError(View view) {
        StatusPageHelper.getInstance().showError();
    }

    public void showEmpty(View view) {
        StatusPageHelper.getInstance().showEmpty();
    }
}