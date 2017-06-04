package com.example.linqingcai.spansizelookupdemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.linqingcai.spansizelookupdemo.adapter.DemoAdapter;
import com.example.linqingcai.spansizelookupdemo.bean.DemoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linqingcai on 2017/6/4.
 */
public class MainActivity extends AppCompatActivity {

    public final static int COLUMN_TOATAL = 6;

    private RecyclerView mRecycleView;

    private DemoAdapter mDemoAdapter;

    private List<DemoBean> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView) findViewById(R.id.demo_rv_spansize_lookup);
        initData();
    }

    private void initData() {
        mRecycleView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int margin = parent.getContext().getResources().getDimensionPixelSize(R.dimen.common_item_margin_2_point_5_dp);

                outRect.set(margin, margin, margin, margin);
            }
        });
        GridLayoutManager gm = new GridLayoutManager(this, COLUMN_TOATAL);
        gm.setSpanSizeLookup(getSpanSizeLookup());
        mRecycleView.setLayoutManager(gm);

        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));



        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));



        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));



        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));

        mDemoAdapter = new DemoAdapter(mList);
        mRecycleView.setAdapter(mDemoAdapter);


    }

    /**
     * getSpanSize 获取 占位
     *
     * @return
     */
    public GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (DemoBean.ITEM_TYPE_FULL_TEXT == mList.get(position).itemType) {
                    return 6;

                } else if (DemoBean.ITEM_TYPE_TWO_IMGS == mList.get(position).itemType) {
                    return 3;

                } else if (DemoBean.ITEM_TYPE_THREE_IMGS == mList.get(position).itemType) {
                    return 2;

                } else {

                    return 1;
                }

            }
        };
    }
}
