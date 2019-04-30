package com.example.customview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CustomView_1_1 extends AppCompatActivity {
    private static final String TAG = "CustomView_1_1";

    //https://hencoder.com/ui-1-1/
    //学习目标：直方图、饼图、环形图的实现
    //用简单的几何图形，和简单的旋转移动动画，形成的视觉错觉的艺术图案
    //或者，用随机数的方式，各种各样不同的“森林の精灵”，宫崎骏《幽灵公主》
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_1_1);

//        Log.d(TAG, "onCreate: " + getString(R.color.color8328_1));
//        Log.d(TAG, " " + R.color.color8328_1);
//        Log.d(TAG, "onCreate: " + getColorString(R.color.color8328_1));
    }

    private String getColorString(int Rid) {
//        return String.valueOf(this.getContext().getColor(Rid));

/*        String strColor = String.format("#%06X", Rid);
        return strColor;*/

    return "#" + Integer.toHexString(Rid);
    }
}
