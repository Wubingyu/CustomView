package com.example.customview.FragmentTrans;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.customview.R;

public class ActivityForFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragment);


        Fragment fragment1 = new BlankFragment1();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityForFragment_FrameLayout, fragment1)
                .commit();

    }
}
