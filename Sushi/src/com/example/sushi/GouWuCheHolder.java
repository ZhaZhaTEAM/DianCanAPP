package com.example.jc.store.com.team.bean;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JC on 2016/12/16.
 */
public class GouWuCheHolder {
    private CheckBox tv_checkBox;//选择框
    private ImageView iv_icon;//图标
    private Button jia;//加
    private Button jian;//减
    private Button delete;//删除
    private TextView tv_number;//数量
    private TextView tv_price;//价格
    private TextView tv_name;//名字

    public CheckBox getTv_checkBox() {
        return tv_checkBox;
    }

    public void setTv_checkBox(CheckBox tv_checkBox) {
        this.tv_checkBox = tv_checkBox;
    }

    public ImageView getIv_icon() {
        return iv_icon;
    }

    public void setIv_icon(ImageView iv_icon) {
        this.iv_icon = iv_icon;
    }

    public Button getJia() {
        return jia;
    }

    public void setJia(Button jia) {
        this.jia = jia;
    }

    public Button getJian() {
        return jian;
    }

    public void setJian(Button jian) {
        this.jian = jian;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public TextView getTv_number() {
        return tv_number;
    }

    public void setTv_number(TextView tv_number) {
        this.tv_number = tv_number;
    }

    public TextView getTv_price() {
        return tv_price;
    }

    public void setTv_price(TextView tv_price) {
        this.tv_price = tv_price;
    }

    public TextView getTv_name() {
        return tv_name;
    }

    public void setTv_name(TextView tv_name) {
        this.tv_name = tv_name;
    }
}
