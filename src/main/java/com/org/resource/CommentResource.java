package com.org.resource;

import com.org.model.Comment;
import com.org.pojo.CommentRequest;
import com.org.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/v1")
@Slf4j
@RequiredArgsConstructor
public class CommentResource {

  private final CommentService commentService;


  @PostMapping("posts/{postId}/comments")
  public Comment addComment(@PathVariable Long postId, @RequestBody CommentRequest commentRequest) {
    return commentService.addComment(postId, commentRequest);
  }

  @PostMapping("/{commentId}/like")
  public ResponseEntity<String> likeComment(@PathVariable Long commentId) {
    commentService.likeComment(commentId);
    return ResponseEntity.ok("Comment liked successfully");
  }

  @PostMapping("/{commentId}/dis-like")
  public ResponseEntity<String> dislikeComment(@PathVariable Long commentId) {
    commentService.dislikeComment(commentId);
    return ResponseEntity.ok("Comment disliked successfully");
  }
}
