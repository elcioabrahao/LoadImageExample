package br.com.qpainformatica.qpabbb.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eabrahao on 17/09/15.
 */
public class Page {

    private int page;
    @SerializedName("per_page")
    private int perPage;
    private int pages;
    private int total;
    private List<Shot> shots;

    public Page() {
    }

    public Page(List<Shot> shots, int page, int perPage, int pages, int total) {
        this.shots = shots;
        this.page = page;
        this.perPage = perPage;
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

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int per_page) {
        this.perPage = perPage;
    }
}
