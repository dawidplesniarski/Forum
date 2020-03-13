package com.example.plesniar.service;

import com.example.plesniar.domain.model.User;
import com.example.plesniar.domain.dto.UserDto;
import com.example.plesniar.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(@Autowired UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDto loginUser(String login, String password) throws NoSuchAlgorithmException {
    System.out.println(getMD5(password));

    final User user = userRepository.findByLogin(login);
    if (user == null) {
      return userRepository.save(new User(login,getMD5(password))).dto();
    }
    System.out.println(userRepository.getPassword(login));
    return user.dto();
  }

  String getMD5(String s) throws NoSuchAlgorithmException{
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] messageDigest = md.digest(s.getBytes());
    BigInteger no = new BigInteger(1, messageDigest);
    String hashed = no.toString(16);
    while (hashed.length() < 32) {
      hashed = "0" + hashed;
    }

    return hashed;
  }

}
