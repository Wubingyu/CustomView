package com.example.customview.CustomLayouManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class customLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = "CardLayoutManager";
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //定义竖直方向的偏移量
        int offsetY = 0;
        Log.d(TAG, "onLayoutChildren: ItemCount is: " + getItemCount());
        for (int i = 0; i < getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            Log.d(TAG, "onLayoutChildren: the offsetY is " + offsetY + " width is " + width + " height is " + height);
            layoutDecorated(view, 0, offsetY, width, offsetY + height);
            offsetY += height;
        }
    }


    private View.OnTouchListener mOnTouchListener = (v, event) -> {
/*        RecyclerView.ViewHolder childViewHolder = mRecyclerView.getChildViewHolder(v);
        // 把触摸事件交给 mItemTouchHelper，让其处理卡片滑动事件
        if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
            mItemTouchHelper.startSwipe(childViewHolder);
        }*/
        return false;
    };
}
