package com.blova.blog.entity;


import lombok.Data;

import java.util.List;

@Data
public class Post {
    private Integer id ;
    private String title;
    private String body;
    private String slug;
    private boolean isPublished;
    private boolean isDeleted;
    private Integer createdAt;
    private Integer publishedAt;

    public Post(Integer id, String title, String slug){
        this.id = id;
        this.title = title;
        this.slug = slug;
    }
}
