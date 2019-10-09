package com.gsd.mlh.complexlist;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 *
 */
public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;
    private RecyclerView.Adapter mAdapter;

    /**
     * @param adapter
     * @param space   传入的值，其单位视为dp
     */
    public ItemDecoration(Context context, RecyclerView.Adapter adapter, int space) {
        mAdapter = adapter;
        this.mSpace = dip2px(context, space);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int itemViewType = mAdapter.getItemViewType(parent.getChildAdapterPosition(view));
        Log.i("sdfsdfsxxxxxxxxxx","itemViewType : " + itemViewType);
        if (itemViewType == 1) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            int spanIndex = layoutParams.getSpanIndex();
            outRect.top = mSpace;
            if (spanIndex == 0) {
                // left
                outRect.left = mSpace;
                outRect.right = mSpace / 2;
            } else {
                outRect.right = mSpace;
                outRect.left = mSpace / 2;
            }
        }
    }

    private int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}