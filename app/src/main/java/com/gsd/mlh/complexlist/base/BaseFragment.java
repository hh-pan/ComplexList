package com.gsd.mlh.complexlist.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * Created by Pan
 * desc: Fragmen的基类
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    private View mView;
    private Dialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mView = initLayout();
        ButterKnife.bind(this,mView);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initData();
        initView();
        initListener();
    }

    protected void initListener() {
    }

    protected abstract View initLayout();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化视图
     */
    protected void initView() {

    }

    /**
     * 子类实现该方法执行初始化操作
     */
    protected void init() {

    }
}
