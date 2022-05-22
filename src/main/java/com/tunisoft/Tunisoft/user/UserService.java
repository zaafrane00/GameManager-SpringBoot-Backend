package com.tunisoft.Tunisoft.user;

import com.tunisoft.Tunisoft.role.Role;
import com.tunisoft.Tunisoft.role.RoleDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements IUserService{
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database", user.getName());
        return userDao.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getName());
        return roleDao.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("adding new role {} to user {}", roleName,email);
        User user=userDao.findByEmail(email);
        Role role =roleDao.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String email) {
        log.info("fetching user {}",email);
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users");
        return userDao.findAll();
    }
}
