package com.example.customview.mView_1_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.customview.R;

/**
 * 动画化 参考：HenCoder:  https://hencoder.com/ui-1-6/
 * 1、在onDraw中，每次重绘 参考：https://juejin.im/post/59f5609851882534af2538c0
 * 2、属性动画。（这块我其实不是很懂 参考：https://blog.csdn.net/qy1993qy/article/details/52824888
 */
public class Anim_HistogramsView extends View {
    private static final String TAG = "Anim_HistogramsView";
        private float n = 0;
    Paint paint_line;
    Paint paint_Rect;
    Paint paint_text;

    Path path_lines;
    Path path_rects;
    Path path_texts;

    public Anim_HistogramsView(Context context) {
        super(context);
        init();
    }

    public Anim_HistogramsView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Anim_HistogramsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 画笔的设置；
     * path的设置。 -> Path的使用先缓一缓
     */
    private void init() {
        paint_line = new Paint();
        paint_Rect = new Paint();
        paint_text = new Paint();

        paint_line.setAntiAlias(true);
        paint_line.setColor(Color.parseColor(getColorString(R.color.color8328_2)));
        paint_line.setStrokeWidth(3);

        paint_Rect.setAntiAlias(true);
        paint_Rect.setColor(Color.parseColor(getColorString(R.color.color8328_4)));
        paint_Rect.setStyle(Paint.Style.FILL_AND_STROKE);

        paint_text.setAntiAlias(true);
        paint_text.setColor(Color.parseColor(getColorString(R.color.color8328_2)));
        paint_text.setTextAlign(Paint.Align.CENTER);  //居中

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor(getColorString(R.color.color8328_1)));

        //画坐标轴
        canvas.drawLine(70, 200, 70, 600, paint_line);
        canvas.drawLine(70, 600, 700, 600, paint_line);

        //画矩形
/*        canvas.drawRect(160, 570, 220, 597, paint_Rect);
        canvas.drawRect(250, 520, 310, 597, paint_Rect);
        canvas.drawRect(340, 450, 400, 597, paint_Rect);
        canvas.drawRect(430, 500, 490, 597, paint_Rect);*/

        //写文字
        setTextSizeForWidth(paint_text,50,"第一个");
        canvas.drawText("第一个", 190, 630, paint_text);

        setTextSizeForWidth(paint_text,50,"Harry Potter");
        canvas.drawText("Harry Potter", 280, 630, paint_text);

        setTextSizeForWidth(paint_text, 50, "简 爱");
        canvas.drawText("简 爱", 370, 630, paint_text);

        setTextSizeForWidth(paint_text, 50, "吉普赛人");
        canvas.drawText("吉普赛人", 460, 630, paint_text);

        //动画效果，绘制矩形，每次绘制一部分
        //？？疑惑，onDraw会不停的重调？时间间隔是多少？如何不停的重调那岂不是要占用很多的资源？？
        //会重绘是因为调用函数进行强行重绘 postInvalidate();
        n += 0.1;
        if (n > 10){
            canvas.drawRect(160, 570, 220, 597, paint_Rect);
            canvas.drawRect(250, 520, 310, 597, paint_Rect);
            canvas.drawRect(340, 450, 400, 597, paint_Rect);
            canvas.drawRect(430, 500, 490, 597, paint_Rect);
        }
        else {
            Log.d(TAG, "onDraw: " + n);
            canvas.drawRect(160,  (600 - 3 * n), 220, 597, paint_Rect);
            canvas.drawRect(250,  (600 - 8 * n), 310, 597, paint_Rect);
            canvas.drawRect(340, (600 - 15 * n), 400, 597, paint_Rect);
            canvas.drawRect(430,  (600 - 10 * n), 490, 597, paint_Rect);

            postInvalidate();
        }

    }

    /**
     * 根据R.color.xxx 的值，返回颜色的String
     * 一开始预备的String.valueOf(id)的方法是错误的，显示结果如下：color8328_1(#a8d8ea)   ->  -5711638
     * 理由，这是16进制，无符号数。
     * @param Rid
     * @return
     */
    private String getColorString(int Rid) {
//        return String.valueOf(this.getContext().getColor(Rid));
        return getContext().getString(Rid);
    }

    /**
     * 固定文本宽度
     * @param paint
     * @param desiredWidth
     * @param text
     */
    private  void setTextSizeForWidth(Paint paint, float desiredWidth,
                                      String text) {

        // Pick a reasonably large value for the test. Larger values produce
        // more accurate results, but may cause problems with hardware
        // acceleration. But there are workarounds for that, too; refer to
        // https://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
        final float testTextSize = 48f;

        // Get the bounds of the text, using our testTextSize.
        paint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);

        // Calculate the desired size as a proportion of our testTextSize.
        float desiredTextSize = testTextSize * desiredWidth / bounds.width();

        // Set the paint for that size.
        paint.setTextSize(desiredTextSize);
    }

}
