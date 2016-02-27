package com.jzhihui.mmmouzhe.bean;

import android.graphics.Bitmap;

/**
 * Created by 程 on 2016/2/17.
 * 简阅Item的bean
 */
public class JianyueBean {

    private int type;
    private String content;//内容
    private String author;//作者
    private Bitmap icon;

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "JianyueBean{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
