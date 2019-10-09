package com.gsd.mlh.complexlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gsd.mlh.complexlist.ItemBean;
import com.gsd.mlh.complexlist.R;
import com.gsd.mlh.complexlist.Utils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Created by Pan on 2019/10/9.
 * Desc:
 */
public class CommentAdapter extends AdapterDelegate<List<ItemBean>> {

    private LayoutInflater inflater;

    public CommentAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected boolean isForViewType(@NonNull List<ItemBean> items, int position) {
        return items.get(position).type == 2;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new MyViewHolder(inflater.inflate(R.layout.item_comment,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<ItemBean> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {

        Utils.setFullColum(holder);

    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
