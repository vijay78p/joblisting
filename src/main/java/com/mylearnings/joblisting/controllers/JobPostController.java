package com.mylearnings.joblisting.controllers;

import com.mylearnings.joblisting.model.Post;
import com.mylearnings.joblisting.repository.PostRepository;
import com.mylearnings.joblisting.repository.SearchRepository;
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

    @RequestMapping(value="/")
    @ApiIgnore
    public  void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post> searchByText(@PathVariable String text){
        return searchRepository.findByText(text);

    }

    @PostMapping("/post")
    public Post addPost(@RequestBody  Post post){
        return postRepository.save(post);

    }


}
