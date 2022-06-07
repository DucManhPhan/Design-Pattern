package com.manhpd.galleryservice.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GalleryEntity {

    private Integer id;

    private List<Object> images;

}
