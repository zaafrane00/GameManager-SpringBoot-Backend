package com.tunisoft.Tunisoft.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
