package com.manhpd.template_method;

public class ChildrenWebsite extends TemplateWebsite {

    @Override
    void buildContent() {
        System.out.println("Content of ChildrenWebsite is created.");
    }
}
