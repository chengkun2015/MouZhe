package com.jzhihui.mmmouzhe.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by 程 on 2016/1/26.
 * 登录成功或失败返回的javabean
 */
public class LoginBean {
    /**
     * uid : 37
     * avatar : /mz/d/file/avatar/000/00/00/37_90x90.jpg
     * error : 10000
     * vip : 0
     * script :
     */
    public String uid;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String avatar;
    public String error;
    public String vip;
    public String script;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public void setVip(String vip) {
        this.vip = vip;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getUid() {
        return uid;
    }

    public String getAvatar() {
        return avatar;
    }


    public String getVip() {
        return vip;
    }

    public String getScript() {
        return script;
    }

    public static LoginBean getData(String json) {
        return  JSONObject.parseObject(json, LoginBean.class);
    }
}
