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
    public void addRoleToUser(String username, String rolename) {
        log.info("adding role");
        User user=userDAO.findUserByUsername(username);
        Role role=roleDao.findRoleByName(rolename);
        if(user==null || role==null){
            if(user==null){
                log.error(username+" not found");
            }
            if(role==null){
                log.error(rolename+" not found");
            }
        }else
            user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("getting user {}",userName);
        return userDAO.findUserByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting all users");
        return userDAO.findAll();
    }
}
