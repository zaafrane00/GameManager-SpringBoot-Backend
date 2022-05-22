package com.tunisoft.Tunisoft.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

/*    @Query(
           value= "select distinct u" +
            " from users u" +
            "where u.email=+:email",
             nativeQuery = true)
    User findByEmail(@Param("email")String email);*/

    User findUserByUsername(String username);
}
