package com.tunisoft.Tunisoft.role;

import com.tunisoft.Tunisoft.user.User;

import java.util.List;

public interface IRoleService {


    Role saveRole(Role role);
    void addRoleToUser(String email,String roleName);
    User getUser(String email);
    User getUser();
}
