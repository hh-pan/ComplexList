package com.gsd.mlh.complexlist.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.gsd.mlh.complexlist.ItemBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Pan on 2019/10/9.
 * Desc:
 */
public class ComplextListAdapter extends RecyclerView.Adapter {

    private final AdapterDelegatesManager<List<ItemBean>> manager;
    private List<ItemBean> dataList;
    private Context context;

    public ComplextListAdapter(Context context, List<ItemBean> dataList) {
        this.context = context;
        this.dataList = dataList;

        manager = new AdapterDelegatesManager<>();
        manager.addDelegate(new CommentAdapter(context))
                .addDelegate(new InterestAdapter(context))
                .addDelegate(new RecommandTitle(context))
                .addDelegate(new LoadingView(context))
                .addDelegate(new HeadAdapter(context));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return manager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        manager.onBindViewHolder(dataList, position, holder);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return manager.getItemViewType(dataList, position);
    }
}
