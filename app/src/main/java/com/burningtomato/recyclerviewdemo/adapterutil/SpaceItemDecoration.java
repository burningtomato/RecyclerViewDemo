package com.burningtomato.recyclerviewdemo.adapterutil;


import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView的行间距设置类
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space = 0;

    /**
     *
     * @param space 行间距大小 px
     */
    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
//        if (parent.getChildAdapterPosition(view) != 0) {//第一行除外
            outRect.top = space;
//        }
    }
}
