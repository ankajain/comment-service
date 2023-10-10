package com.org.validation;

import com.org.dao.CommentRepository;
import com.org.dao.PostRepository;
import com.org.dao.UserRepository;
import com.org.exception.CommentNotFoundException;
import com.org.exception.InvalidParentComment;
import com.org.exception.InvalidPostException;
import com.org.exception.UserNotFoundException;
import com.org.pojo.CommentRequest;
import org.springframework.stereotype.Component;

@Component
public class CommentValidation {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;
  private final PostRepository postRepository;

  public CommentValidation(CommentRepository commentRepository, UserRepository userRepository,
      PostRepository postRepository) {
    this.commentRepository = commentRepository;
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  public void validate(Long postId, CommentRequest commentRequest) {

    if (!postRepository.findById(postId).isPresent()) {
      throw new InvalidPostException("Post not found with ID: " + postId);
    }
    if(commentRequest.getParentId()!= null && commentRequest.getParentId()!= 0L && !commentRepository.findById(
        commentRequest.getParentId()).isPresent()){
      throw new InvalidParentComment("Parent Comment not found with ID: " + commentRequest.getParentId());
    }

    if(!userRepository.findById(commentRequest.getUserId()).isPresent()){
      throw new UserNotFoundException("Invalid User with Id: " + commentRequest.getUserId());
    }
  }

  public void validate(Long commentId) {
    if( !commentRepository.findById(commentId).isPresent()){
      throw new CommentNotFoundException(" Comment not found with ID: " + commentId);
    }
  }
}
