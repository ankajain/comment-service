package com.org.service;

import com.org.dao.UserRepository;
import com.org.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  public User addUser(String name) {

    User user = new User();
    user.setUsername(name);
    // Save the comment to the database
    return userRepository.save(user);
  }
}
