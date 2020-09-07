package com.ms.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private ViewPager2 viewPager2;
    private List<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ms.app.R.layout.activity_main2);
        viewPager2  = findViewById(R.id.viewPager2);

        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(MyFragment.newInstance());

        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment = fragmentList.get(position);
                return fragment;
            }

            @Override
            public int getItemCount() {
                return fragmentList.size();
            }
        });



    }
}
