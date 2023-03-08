package com.mylearnings.joblisting.controllers;

import com.mylearnings.joblisting.model.Post;
import com.mylearnings.joblisting.repository.PostRepository;
import com.mylearnings.joblisting.repository.SearchRepository;
import com.mylearnings.joblisting.services.MongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    SearchRepository searchRepository;
    @Autowired
    MongodbService mongodbService;

    @RequestMapping(value="/")
    @ApiIgnore
    public  void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return mongodbService.getAllJobPost();//postRepository.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post> searchByText(@PathVariable String text){
        return searchRepository.findByText(text);

    }

    @PostMapping("/post")
    public Post addPost(@RequestBody  Post post){
        return mongodbService.addJobPost(post); //postRepository.save(post);
    }

}
