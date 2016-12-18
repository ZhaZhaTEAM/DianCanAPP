package com.example.jc.store.com.team.com.team.adapter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asus on 2016/12/17.
 */
public class OrderItemHolder {
    public ImageView getF_goods_pic() {
        return f_goods_pic;
    }

    public void setF_goods_pic(ImageView f_goods_pic) {
        this.f_goods_pic = f_goods_pic;
    }

    public TextView getF_goods_title() {
        return f_goods_title;
    }

    public void setF_goods_title(TextView f_goods_title) {
        this.f_goods_title = f_goods_title;
    }

    public TextView getF_goods_price() {
        return f_goods_price;
    }

    public void setF_goods_price(TextView f_goods_price) {
        this.f_goods_price = f_goods_price;
    }

    public TextView getF_goods_number() {
        return f_goods_number;
    }

    public void setF_goods_number(TextView f_goods_number) {
        this.f_goods_number = f_goods_number;
    }

    public TextView getF_goods_totalprice() {
        return f_goods_totalprice;
    }

    public void setF_goods_totalprice(TextView f_goods_totalprice) {
        this.f_goods_totalprice = f_goods_totalprice;
    }
    ImageView f_goods_pic;
    TextView f_goods_title;
    TextView f_goods_price;
    TextView f_goods_number;
    TextView f_goods_totalprice;
}
