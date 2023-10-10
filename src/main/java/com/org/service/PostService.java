package com.org.service;

import com.org.model.Post;
import com.org.pojo.PostRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService {


  public Post addPost(PostRequest postRequest) {

    // Save the comment to the database
    return null;
  }

  public void likePost(Long postId) {
  }

  public void disLikePost(Long postId) {
  }
}
