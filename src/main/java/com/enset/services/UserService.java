package com.enset.services;

import com.enset.entites.Role;
import com.enset.entites.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
}
