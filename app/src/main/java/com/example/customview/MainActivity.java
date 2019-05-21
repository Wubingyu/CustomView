package com.example.customview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.customview.CustomLayouManager.ActivityCustomLayoutManager;
import com.example.customview.FragmentTrans.ActivityForFragment;

public class MainActivity extends AppCompatActivity {
    //好奇，java这样的传递方式之后，成员变量的数据就更新了嘛？
    Button button_1_1, button_setting,button_fragmentTrans,button_CustomLayoutManager;
    ImageView syncView;
    private final static int NORMAL_START = 0;
    private final static int TRANS_DEFAULT_START = 1;
    private final static int TRANS_SHARE_START = 2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //除了使用XML的Theme标签指定意外，也可以在java代码中设置transition动画
        //？？？下面这一行报错：Caused by: android.util.AndroidRuntimeException: requestFeature() must be called before adding content
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        setupWindowAnimations();

        find_and_clickJump(button_1_1, R.id.jump_1_1, CustomView_1_1.class, NORMAL_START);
        //为什么在XML中指定了转场动画(Theme)却没有用啊！ 因为启动Activity的方式要变化一下
        find_and_clickJump(button_setting, R.id.jump_setting, SettingsActivity.class, TRANS_DEFAULT_START);
        find_and_clickJump(syncView, R.id.sync_main, ShareTransition.class, TRANS_SHARE_START);
        find_and_clickJump(button_fragmentTrans, R.id.jump_FragmentTrans, ActivityForFragment.class, NORMAL_START);
        find_and_clickJump(button_CustomLayoutManager, R.id.jump_CustomLayoutManager, ActivityCustomLayoutManager.class, NORMAL_START);


    }


    /**
     *
     * @param view 事实上，我们当然完全可以不指定view。但是这样在整个java文件的其他地方我们就没有办法使用了。 //来自find_and_clickJump(button_1_1, R.id.jump_setting, SettingsActivity.class);这行代码的错误的思考
     * @param Rid
     * @param activity
     * @param startWay 不同的启动方式
     */
    private void find_and_clickJump(View view, int Rid, Class<?> activity, int startWay) {
        view = findViewById(Rid);
        view.setOnClickListener(v -> click_jump(activity, startWay));

    }

    private void click_jump(Class<?> activity, int startWay) {
        Intent intent = new Intent(MainActivity.this, activity);
//        startActivity(intent);


        switch (startWay) {
            case NORMAL_START:
                startActivity(intent);
                break;
            case TRANS_DEFAULT_START:
                //用动画的方式启动Activity
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case TRANS_SHARE_START:
                //设置启动方式
                // inside your activity (if you did not enable transitions in your theme)
                //报错：android.util.AndroidRuntimeException: requestFeature() must be called before adding content
                //它是指，必须放在下面这两行之前。 但是啊！！这一行的目的是，开始转场动画，你已经开启过了啊。。你啊 是不是傻呀
        //                super.onCreate(savedInstanceState);
        //                setContentView(R.layout.activity_main);
//                getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

                // set an enter transition
                //在xml中设置，排除菜单栏的动画
                ChangeBounds changeBounds = (ChangeBounds) TransitionInflater.from(this).inflateTransition(R.transition.share_trans);
                getWindow().setEnterTransition(changeBounds);
                // set an exit transition
                getWindow().setExitTransition(changeBounds);

                //启动时带上指定的共享元素
                syncView = findViewById(R.id.sync_main);
                View shareView_sync = syncView;
                String transitionName = getString(R.string.trans_shareName_sync);

                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, shareView_sync, transitionName);
                startActivity(intent, transitionActivityOptions.toBundle());

        }
    }
}
