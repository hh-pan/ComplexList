package com.gsd.mlh.complexlist;

import com.gsd.mlh.complexlist.adapter.BaseViewpagerAdapter;
import com.gsd.mlh.complexlist.base.BaseActivity;
import com.gsd.mlh.complexlist.fragment.IndexFragment;
import com.gsd.mlh.complexlist.fragment.MineFragment;
import com.gsd.mlh.complexlist.widget.BottomBarLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bbl)
    BottomBarLayout bbl;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private Fragment[] pageArray;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();

        IndexFragment indexFragment = new IndexFragment();
        MineFragment mineFragment = new MineFragment();
        pageArray = new Fragment[]{indexFragment, mineFragment};

        BaseViewpagerAdapter adapter = new BaseViewpagerAdapter(getSupportFragmentManager(), 1,pageArray);
        viewpager.setAdapter(adapter);
        bbl.setViewPager(viewpager);
    }
}
