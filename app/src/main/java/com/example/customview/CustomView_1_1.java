package com.example.customview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.customview.mView_1_1.HisView_ObjAnim;

public class CustomView_1_1 extends AppCompatActivity {
    private static final String TAG = "CustomView_1_1";

    TextView textView1, textView2;
    HisView_ObjAnim hisView_objAnim;

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

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView1.setOnClickListener(v -> setAnim1());
        textView2.setOnClickListener(v -> setAnim2());

        hisView_objAnim = findViewById(R.id.hisView);
        hisView_objAnim.setOnClickListener(v -> objAnim());


    }

    /**
     * 自定义view的属性动画，
     * ？？？在使用ObjectAnimator的时候需要考虑线程安全吗？不需要，被封装好了
     */
    private void objAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(hisView_objAnim, "progress", 0, 1, 2, 4, 6, 10, 0);
        animator.setDuration(1000);
        animator.start();
    }

    /**
     * 直接使用android原装控件的 视图动画、属性动画
     * 使用自定义View的属性动画
     */
    private void setAnim1() {

        //视图动画，如何设置重复来着？
        textView1.animate().translationX(100).setDuration(500);
    }

    private void setAnim2() {

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textView2, "alpha", 1, 0, 1);
        animator1.setDuration(2000);
        animator1.start();

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView2, "rotation", 0f, 360f, 720f);
        animator2.setDuration(2000);
        animator2.start();
    }

    private String getColorString(int Rid) {
//        return String.valueOf(this.getContext().getColor(Rid));

/*        String strColor = String.format("#%06X", Rid);
        return strColor;*/

    return "#" + Integer.toHexString(Rid);
    }
}
