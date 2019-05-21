package com.example.customview.FragmentTrans;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.customview.R;

public class ActivityForFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragment);


        Fragment fragment1 = new BlankFragment1();
        Fragment fragment2 = new BlankFragment2();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityForFragment_FrameLayout, fragment1)
                .commit();


        Button jump_1 = findViewById(R.id.jump_Fragment1);
        jump_1.setOnClickListener(v->
                getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_right_in,
                        R.anim.slide_left_out,
                        R.anim.slide_left_in,
                        R.anim.slide_right_out)
//                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
//                    .addToBackStack(null)
                .replace(R.id.ActivityForFragment_FrameLayout, fragment1).commit());

        Button jump_2 = findViewById(R.id.jump_Fragment2);
        jump_2.setOnClickListener(v->
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_right_in,
                                R.anim.slide_left_out,
                                R.anim.slide_left_in,
                                R.anim.slide_right_out)
//                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
//                    .addToBackStack(null)
                        .replace(R.id.ActivityForFragment_FrameLayout, fragment2).commit());

    }
}
