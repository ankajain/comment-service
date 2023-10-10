package com.org.resource;

import com.org.model.Post;
import com.org.pojo.PostRequest;
import com.org.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post/v1")
@Slf4j
@RequiredArgsConstructor
public class PostResource {

  private PostService postService;

  @PostMapping("posts")
  public Post addPost(@RequestBody PostRequest postRequest) {
    return postService.addPost(postRequest);
  }

  @PostMapping("/{id}/like")
  public ResponseEntity<String> likePost(@PathVariable Long postId) {
    postService.likePost(postId);
    return ResponseEntity.ok("Comment liked successfully");
  }

  @PostMapping("/{id}/dis-like")
  public ResponseEntity<String> disLikePost(@PathVariable Long postId) {
    postService.disLikePost(postId);
    return ResponseEntity.ok("Comment dis liked successfully");
  }

}
