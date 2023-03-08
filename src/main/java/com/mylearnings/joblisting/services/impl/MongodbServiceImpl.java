package com.mylearnings.joblisting.services.impl;

import com.mylearnings.joblisting.model.Post;
import com.mylearnings.joblisting.repository.PostRepository;
import com.mylearnings.joblisting.services.MongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongodbServiceImpl implements MongodbService {

    @Autowired
    PostRepository postRepository;
    @Override
    public List<Post> getAllJobPost() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> searchJobPostByText(String text) {
        return null;
    }

    @Override
    public Post addJobPost(Post post) {
        return postRepository.save(post);
    }
}
