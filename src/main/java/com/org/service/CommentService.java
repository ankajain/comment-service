package com.org.service;

import com.org.dao.CommentRepository;
import com.org.dao.PostRepository;
import com.org.dao.UserRepository;
import com.org.model.Comment;
import com.org.pojo.CommentRequest;
import com.org.validation.CommentValidation;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final CommentValidation commentValidation;

  public Comment addComment(Long postId, CommentRequest commentRequest) {
    commentValidation.validate(postId,commentRequest);
    Comment comment = new Comment();
    comment.setContent(commentRequest.getContent());
    comment.setUser(userRepository.findById(commentRequest.getUserId()).get());
    comment.setPost(postRepository.findById(postId).get());
    comment.setCreatedAt(new Date());
    comment.setUpdatedAt(new Date());
    if (commentRequest.getParentId() != null && commentRequest.getParentId()!= 0L) {
      comment.setParentComment(commentRepository.findById(commentRequest.getParentId()).get());
    }

    // Save the comment to the database
    return commentRepository.save(comment);
  }

  public void likeComment(Long commentId) {

    commentValidation.validate(commentId);
    Comment comment = commentRepository.findById(commentId).get();
//    comment.setLikes(comment.getLikes() +1);
    comment.setUpdatedAt(new Date());
    commentRepository.save(comment);
  }
  public void dislikeComment(Long commentId) {
    commentValidation.validate(commentId);
    Comment comment = commentRepository.findById(commentId).get();
//    comment.setDisLikes(comment.getDisLikes() +1);
    comment.setUpdatedAt(new Date());
    commentRepository.save(comment);
  }
}
