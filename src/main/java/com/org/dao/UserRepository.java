package com.org.dao;

import com.org.model.User;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

//@Repository
@Service
public class UserRepository {

  private static final Set<User> storedUser;

  static {
    storedUser = new HashSet<>();
    storedUser.add(new User(123L, "Akanksha Jain"));
  }

  public static Optional<User> getUser(
      final Long id) {
    return storedUser.stream()
        .filter(user -> user.getId().equals(id))
        .findAny();
  }

  public Optional<User> findById(Long userId) {
    return storedUser.stream()
        .filter(user -> user.getId().equals(userId))
        .findAny();
  }

  public User save(User user) {
    storedUser.add(user);
    return user;
  }
}
