package com.manhpd.galleryservice.controller;

import com.manhpd.galleryservice.persistence.entity.GalleryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    public String home() {
        return "Hello world from Gallery service";
    }

    @RequestMapping("/{id}")
    public GalleryEntity getGallery(@PathVariable final int id) {
        GalleryEntity gallery = new GalleryEntity();
        gallery.setId(id);

        List<Object> images = this.restTemplate.getForObject("http://image-service/images", List.class);
        gallery.setImages(images);

        return gallery;
    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin' // We'll add the logic of role based auth later  @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

}
