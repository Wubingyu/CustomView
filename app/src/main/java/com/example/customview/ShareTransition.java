package com.example.customview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/**
 * 学会了简单的在XML中使用Transition。现在想要在我的项目中使用的话，我想要共享式的转场。
 *
 */
public class ShareTransition extends AppCompatActivity {
    ImageView syncView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_transition);

        syncView = findViewById(R.id.sync_share);
        //共享式，想要退场的方式
        syncView.setOnClickListener(v -> finishAfterTransition());

    }
}
