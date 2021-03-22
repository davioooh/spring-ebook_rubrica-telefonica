package com.davioooh.rubricatelefonica.users;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsersRepository {
  private JdbcTemplate jdbcTemplate;

  public UsersRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Optional<User> findByUsername(String username) {
    try {
      return Optional.ofNullable(
        jdbcTemplate.queryForObject(
          "select * from users where username = ?",
          new UserRowMapper(),
          username
        )
      );
    } catch (IncorrectResultSizeDataAccessException ex) {
      return Optional.empty();
    }
  }

  static class UserRowMapper extends BeanPropertyRowMapper<User> {
    public UserRowMapper() {
      super(User.class);
    }
  }

}