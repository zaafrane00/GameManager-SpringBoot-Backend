package com.tunisoft.Tunisoft.user;
import com.tunisoft.Tunisoft.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
