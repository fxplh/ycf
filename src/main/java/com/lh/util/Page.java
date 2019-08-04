package com.lh.util;

/**
 * Created by Administrator on 2019/5/31.
 */
public class Page {
    private int count;//总数
    private int size = 8;//每页显示数
    private int currPage;//当前页数
    private int countPage;//总页数

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getCountPage() {
        if(count%size==0){
            return count/size;
        }
        return (count/size)+1;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }
}
