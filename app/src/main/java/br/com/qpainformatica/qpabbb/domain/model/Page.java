package br.com.qpainformatica.qpabbb.domain.model;

import java.util.List;

/**
 * Created by eabrahao on 17/09/15.
 */
public class Page {

    private int page;
    private int per_page;
    private int pages;
    private int total;
    private List<Shot> shots;

    public Page() {
    }

    public Page(List<Shot> shots, int page, int per_page, int pages, int total) {
        this.shots = shots;
        this.page = page;
        this.per_page = per_page;
        this.pages = pages;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Shot> getShots() {
        return shots;
    }

    public void setShots(List<Shot> shots) {
        this.shots = shots;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }
}
