package com.gsd.mlh.complexlist;

import android.os.Bundle;
import android.os.Handler;

import com.gsd.mlh.complexlist.adapter.ComplextListAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recy;
    private ComplextListAdapter adapter;
    private List<ItemBean> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();


        recy = findViewById(R.id.recy);
        adapter = new ComplextListAdapter(this, dataList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recy.addItemDecoration(new ItemDecoration(this, adapter, 8));
        recy.setLayoutManager(layoutManager);
        recy.setAdapter(adapter);

        initListener();

    }

    private void initListener() {

        recy.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int[] array = new int[2];
                    int[] lastVisibleItemPositions = manager.findLastVisibleItemPositions(array);
                    int totalItemCount = manager.getItemCount();
                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItemPositions[0] == (totalItemCount - 1)) {
                        //加载更多功能的代码
                        getMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }

    private void initData() {

        for (int i = 0; i < 11; i++) {
            ItemBean bean = new ItemBean();
            if (i == 0) {
                bean.type = 1;
            } else {
                bean.type = 2;
            }
            dataList.add(bean);
        }
        //标题
        ItemBean bean = new ItemBean();
        bean.type = 3;
        dataList.add(bean);

        ItemBean load = new ItemBean();
        load.type = 5;
        dataList.add(load);
    }
    
    private void getMore() {
        //模拟数据请求
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<ItemBean> more = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    ItemBean interest = new ItemBean();
                    interest.type = 4;
                    more.add(interest);
                }
                dataList.addAll(dataList.size() - 1, more);
                adapter.notifyDataSetChanged();
            }
        },2000);
    }
}
