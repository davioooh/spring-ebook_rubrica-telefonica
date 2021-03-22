package com.davioooh.rubricatelefonica.security;

import com.davioooh.rubricatelefonica.users.User;
import com.davioooh.rubricatelefonica.users.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RubricaTelefonicaUserDetailsService implements UserDetailsService {

  private UsersRepository usersRepository;

  public RubricaTelefonicaUserDetailsService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = usersRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException(
        "Username '" + username + "' not found")
      );

    return org.springframework.security.core.userdetails.User.builder()
      .username(user.getUsername())
      .password(user.getPassword())
      .roles("USER")
      .build();
  }

}