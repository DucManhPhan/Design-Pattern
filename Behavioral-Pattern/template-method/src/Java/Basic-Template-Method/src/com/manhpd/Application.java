package com.manhpd;

import com.manhpd.template_method.CommercialWebsite;
import com.manhpd.template_method.TemplateWebsite;

public class Application {

    public static void main(String[] args) {
        TemplateWebsite templateWebsite = new CommercialWebsite();
        templateWebsite.build();
    }

}
