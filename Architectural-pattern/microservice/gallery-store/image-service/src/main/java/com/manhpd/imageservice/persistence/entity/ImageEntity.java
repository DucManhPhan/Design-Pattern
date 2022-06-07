package com.manhpd.imageservice.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ImageEntity {

    private Integer id;

    private String title;

    private String url;

}
