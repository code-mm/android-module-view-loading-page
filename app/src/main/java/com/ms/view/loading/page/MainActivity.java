package com.ms.view.loading.page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusPageHelper.getInstance().init(this);
    }

    public void hideAll(View view) {
        StatusPageHelper.getInstance().hideAllStatus();
    }

    public void showLoading(View view) {
        Toast.makeText(this, "showLoading", Toast.LENGTH_SHORT).show();
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