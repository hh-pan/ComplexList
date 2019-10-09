package com.gsd.mlh.complexlist;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Created by Pan on 2019/10/9.
 * Desc:
 */
public class Utils {
    
    /**
     * 显示一行
     *
     * @param viewHolder
     */
    public static void setFullColum(RecyclerView.ViewHolder viewHolder) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams)
                viewHolder.itemView.getLayoutParams();
        layoutParams.setFullSpan(true);
    }
}
