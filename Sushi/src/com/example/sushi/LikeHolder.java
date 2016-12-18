package com.example.jc.store.com.team.com.team.adapter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asus on 2016/12/18.
 */
public class LikeHolder {
    ImageView iv_icon;//图标
    TextView tv_title;//名字
    TextView tv_detail;//细节
    TextView tv_price;//价格
    Button unlike;
    Button add;
    public ImageView getIv_icon() {
        return iv_icon;
    }

    public void setIv_icon(ImageView iv_icon) {
        this.iv_icon = iv_icon;
    }

    public TextView getTv_title() {
        return tv_title;
    }

    public void setTv_title(TextView tv_title) {
        this.tv_title = tv_title;
    }

    public TextView getTv_detail() {
        return tv_detail;
    }

    public void setTv_detail(TextView tv_detail) {
        this.tv_detail = tv_detail;
    }

    public Button getUnlike() {
        return unlike;
    }

    public void setUnlike(Button unlike) {
        this.unlike = unlike;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public TextView getTv_price() {
        return tv_price;
    }

    public void setTv_price(TextView tv_price) {
        this.tv_price = tv_price;
    }


}
