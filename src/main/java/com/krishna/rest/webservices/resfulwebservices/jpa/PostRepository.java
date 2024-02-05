package com.krishna.rest.webservices.resfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.rest.webservices.resfulwebservices.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
