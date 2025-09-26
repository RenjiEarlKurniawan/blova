package com.blova.blog.service;

import com.blova.blog.entity.Post;
import com.blova.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;



@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {

    @Autowired
    PostRepository postRepository;


    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostBySlug(String slug){
        return postRepository.findBySlugAndIsDeleted(slug, false).orElse(null);
    }

    public Post createPost(Post post){
        post.setCreatedAt(Instant.now().getEpochSecond());
        return postRepository.save(post);

    }

    public Post updatePostBySlug(String slug, Post post){
        Post savedPost = postRepository.findBySlugAndIsDeleted(slug, false).orElse(null);

        if(savedPost == null){
            return null;
        }

        post.setId(savedPost.getId());

        return postRepository.save(post);
    }

    public Boolean deletedPostById(Integer id){
        Post post = postRepository.findById(id).orElse(null);
        if(post == null){
            return false;
        }
        post.setDeleted(true);
        postRepository.save(post);
        return true;
    }

    public Post publishPost(Integer id){
        Post post = postRepository.findByIdAndIsDeleted(id, false).orElse(null);
        if(post == null) {
            return null;
        }
        post.setPublished(true);
        post.setPublishedAt(Instant.now().getEpochSecond());
        return postRepository.save(post);
    }
}


