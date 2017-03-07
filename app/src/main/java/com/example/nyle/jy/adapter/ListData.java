package com.example.nyle.jy.adapter;

/**
 * Created by NYL on 2017/3/3 0003.
 * Email:1174212579@qq.com
 */

public class ListData {
    public static final int SEND=1;
    public static final int RECEIVER=2;
    private int flag;
    private String content;

    public ListData(String content,int flag){
        this.content=content;
        this.flag=flag;
        setContent(content);
        setFlag(flag);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
