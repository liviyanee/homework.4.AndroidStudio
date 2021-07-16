package com.example.homework4androidstudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnopen;
    EditText etValue;
    boolean temp = true;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        btnopen = findViewById(R.id.btn_open);
        etValue = findViewById(R.id.et_value);
        btnopen.setOnClickListener(v -> {
            String text = etValue.getText().toString();
            if (text != ""){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (temp) {
                    transaction.replace(R.id.container_fragment1, FirstFragment.newInstance(text, "TEXT 2"));
                    transaction.addToBackStack("FirstFragment");
                    temp = false;
                }else {
                    transaction.replace(R.id.container_fragment1, SecondFragment.newInstance(text, "TEXT 2"));
                    transaction.addToBackStack("SecondFragment");
                    temp = true;
                }
                transaction.commit();
            } else {
                etValue.setError("Please, enter text!");
            }

        });
    }
}