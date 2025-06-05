package com.lab231.myblog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "page_view")
public class PageView {
    @Id
    @Column(unique = true)
    private String page;
    private Long count;

    public PageView() {}

    public PageView(String page, Long count) {
        this.page = page;
        this.count = count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
