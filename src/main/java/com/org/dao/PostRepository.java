package com.org.dao;

import com.org.model.Post;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

//@Repository
@Service
//It will actually store comment into database
public class PostRepository {

  public static final Set<Post> storedPosts;

  static {
    storedPosts = new HashSet<>();
    storedPosts.add(new Post(123L, "This is my country my project"));
  }

  public static Optional<Post> getPost(
      final Long id) {
    return storedPosts.stream()
        .filter(post -> post.getId().equals(id))
        .findAny();
  }

  public Optional<Post> findById(Long postId) {
    return storedPosts.stream()
        .filter(post -> post.getId().equals(postId))
        .findAny();
  }

  public Post save(Post post) {
    storedPosts.add(post);
    return post;
  }
}
