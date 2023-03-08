package com.mylearnings.joblisting.repository;

import com.mylearnings.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
