package com.tunisoft.Tunisoft.user;

import com.tunisoft.Tunisoft.role.Role;

import java.util.List;

public interface IUserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String roleName,String userName);
    User getUser(String userName);
    List<User> getUsers();
}
