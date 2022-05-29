package com.rory.userservice.service;

import com.rory.userservice.domain.AppUser;
import com.rory.userservice.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getAppUsers();
}
