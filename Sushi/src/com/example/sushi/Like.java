package com.example.jc.store.com.team.bean;

/**
 * “喜欢”表
 * Created by JC on 2016/12/14.
 */
public class Like {
    private int f_id;// 主键id
    private String f_userid;//用户id
    private String f_goodid;//商品id



    public Like(int f_id, String f_userid, String f_goodid) {
        this.f_id=f_id;
        this.f_userid=f_userid;
        this.f_goodid=f_goodid;

    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_userid() {
        return f_userid;
    }

    public void setF_userid(String f_userid) {
        this.f_userid = f_userid;
    }

    public String getF_goodid() {
        return f_goodid;
    }

    public void setF_goodid(String f_goodid) {
        this.f_goodid = f_goodid;
    }

}
