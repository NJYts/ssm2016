package com.atguigu.p2p.test.shufa.fivesearch;

public class IndexItem {
    public int index;
    public int start;
    public int length;

    public IndexItem(int index, int start, int length) {
        this.index = index;
        this.start = start;
        this.length = length;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
