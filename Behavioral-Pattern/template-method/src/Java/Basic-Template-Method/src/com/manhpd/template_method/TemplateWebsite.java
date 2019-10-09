package com.manhpd.template_method;

public abstract class TemplateWebsite {

    public void buildTopBar() {
        System.out.println("TopBar is displayed.");
    }

    public void buildSideBar() {
        System.out.println("SideBar is displayed.");
    }

    public void buildBottomBar() {
        System.out.println("BottomBar is displayed.");
    }

    public void build() {
        this.buildTopBar();
        this.buildSideBar();
        this.buildContent();
        this.buildBottomBar();
    }

    abstract void buildContent();

}