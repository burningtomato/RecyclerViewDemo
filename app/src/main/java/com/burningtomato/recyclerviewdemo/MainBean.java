package com.burningtomato.recyclerviewdemo;

public class MainBean {
    private String content;
    private int index;

    public MainBean(String mContene, int i) {
        this.content = mContene ;
        index = i;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
