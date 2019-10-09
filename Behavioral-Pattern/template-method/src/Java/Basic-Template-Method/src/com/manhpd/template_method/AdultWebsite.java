package com.manhpd.template_method;

public class AdultWebsite extends TemplateWebsite {

    @Override
    void buildContent() {
        System.out.println("Content of AdultWebsite is created.");
    }
}
