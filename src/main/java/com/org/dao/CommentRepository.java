package com.org.dao;

import com.org.model.Comment;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//It will actually store comment into database
@Service
@RequiredArgsConstructor
public class CommentRepository {

  private static final Set<Comment> storedComments;

  static {
    storedComments = new HashSet<>();
    Comment comment = new Comment(PostRepository.getPost(123L).get(),
        UserRepository.getUser(123L).get(), "You are absolutely right");
    comment.setId(123L);
    storedComments.add(comment);
  }


  public Comment save(Comment comment) {
    storedComments.add(comment);
    return comment;
  }

  public Optional<Comment> findById(Long commentId) {
    return storedComments.stream()
        .filter(comment -> commentId.equals(comment.getId()))
        .findAny();
  }
}
