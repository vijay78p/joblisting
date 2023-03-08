package com.mylearnings.joblisting.services;

import com.mylearnings.joblisting.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MongodbService {

    public List<Post> getAllJobPost();
    public List<Post> searchJobPostByText(String text);
    public  Post addJobPost(Post post);

}
