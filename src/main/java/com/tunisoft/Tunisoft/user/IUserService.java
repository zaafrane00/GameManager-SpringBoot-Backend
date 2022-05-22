package com.tunisoft.Tunisoft.user;

import com.tunisoft.Tunisoft.role.Role;

import java.util.List;

public interface IUserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String rolename,String email);
    User getUser(String email);
    List<User> getUsers();
}
