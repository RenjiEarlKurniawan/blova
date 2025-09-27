package com.blova.blog.service;

import com.blova.blog.entity.Comment;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    public Iterable<Comment> getComment(String postSlug, Integer pageNo, Integer limit){
        List<Comment> commentList = new ArrayList<>();
        return commentList;
    }

    public Comment getComment(Integer id){
        return new Comment();
    }

    public Comment createComment(Comment comment){
        return comment;
    }
}
