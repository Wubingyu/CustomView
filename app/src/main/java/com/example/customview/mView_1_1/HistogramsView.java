package com.example.customview.mView_1_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

/**
 * 画直方图，
 * 第一是样式的绘制：两条坐标线，文字，矩形（填充式）
 * 第二是动画，直方图的出现动画
 */
public class HistogramsView extends View {
    Paint paint_line;
    Paint paint_Rect;
    Paint paint_text;

    Path path_lines;
    Path path_rects;
    Path path_texts;

    public HistogramsView(Context context) {
        super(context);
        init();
    }

    public HistogramsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HistogramsView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        canvas.drawRect(160, 570, 220, 597, paint_Rect);
        canvas.drawRect(250, 520, 310, 597, paint_Rect);
        canvas.drawRect(340, 450, 400, 597, paint_Rect);
        canvas.drawRect(430, 500, 490, 597, paint_Rect);

        //写文字
        setTextSizeForWidth(paint_text,50,"第一个");
        canvas.drawText("第一个", 190, 630, paint_text);

        setTextSizeForWidth(paint_text,50,"Harry Potter");
        canvas.drawText("Harry Potter", 280, 630, paint_text);

        setTextSizeForWidth(paint_text, 50, "简 爱");
        canvas.drawText("简 爱", 370, 630, paint_text);

        setTextSizeForWidth(paint_text, 50, "吉普赛人");
        canvas.drawText("吉普赛人", 460, 630, paint_text);



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
