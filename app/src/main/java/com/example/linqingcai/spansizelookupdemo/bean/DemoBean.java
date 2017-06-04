package com.example.linqingcai.spansizelookupdemo.bean;

/**
 * Created by linqingcai on 2017/6/4.
 */

public class DemoBean {
    public static final int ITEM_TYPE_FULL_TEXT = 1;
    public static final int ITEM_TYPE_TWO_IMGS = 2;
    public static final int ITEM_TYPE_THREE_IMGS = 3;

    public int itemType;

    public DemoBean(int itemType) {
        this.itemType = itemType;
    }
}
