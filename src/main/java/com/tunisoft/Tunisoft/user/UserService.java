package com.tunisoft.Tunisoft.user;

import com.tunisoft.Tunisoft.role.Role;
import com.tunisoft.Tunisoft.role.RoleDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService{
    private final UserDAO userDAO;
    private final RoleDAO roleDao;


    @Override
    public User saveUser(User user) {
        log.info("saving User {}",user);
        return userDAO.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {}",role);
        return roleDao.save(role);
    }

    @Override
    public void addRoleToUser(String rolename, String email) {
        log.info("adding role");
        User user=userDAO.findByEmail(email);
        Role role=roleDao.findByName(rolename);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String email) {
        log.info("getting user {}",email);
        return userDAO.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting all users");
        return userDAO.findAll();
    }
}
