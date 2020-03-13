package com.example.plesniar.service;

import com.example.plesniar.domain.model.User;
import com.example.plesniar.domain.dto.UserDto;
import com.example.plesniar.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(@Autowired UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDto loginUser(String login, String password) {
    final User user = userRepository.findByLogin(login);
    if (user == null) {
      return userRepository.save(new User(login,password)).dto();
    }

    return user.dto();
  }

}
