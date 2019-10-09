package com.manhpd.template_method;

public class CommercialWebsite extends TemplateWebsite {

    @Override
    void buildContent() {
        System.out.println("Content of CommercialWebsite is created.");
    }
}
