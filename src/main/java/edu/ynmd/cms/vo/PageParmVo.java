package edu.ynmd.cms.vo;

import java.io.Serializable;

public class PageParmVo implements Serializable {
    private int page; //当前页
    private int pagesize;//页面条目数量

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
