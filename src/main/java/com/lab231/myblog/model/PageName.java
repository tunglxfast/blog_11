package com.lab231.myblog.model;

public enum PageName {
    BLOG("blog"),
    ABOUT("about"),
    DETAIL("detail"),
    OVERVIEW("overview");


    public final String name;

    private PageName(String name){
        this.name = name;
    }
}
