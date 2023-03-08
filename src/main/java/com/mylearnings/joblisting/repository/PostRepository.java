package com.mylearnings.joblisting.repository;

import com.mylearnings.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
