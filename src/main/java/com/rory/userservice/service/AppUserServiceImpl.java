package com.rory.userservice.service;

import com.rory.userservice.dao.AppUserDao;
import com.rory.userservice.dao.RoleDao;
import com.rory.userservice.domain.AppUser;
import com.rory.userservice.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j //Slf4j is for logging
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDao appUserDao;
    private final RoleDao roleDao;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new app user {} to the database", user.getName());
        return appUserDao.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleDao.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to the user {}", roleName, username);
        AppUser appUser = appUserDao.findByUsername(username);
        Role role = roleDao.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching  user {}", username);
        return appUserDao.findByUsername(username);
    }

    @Override
    public List<AppUser> getAppUsers() {
        log.info("Fetching all users");
        return appUserDao.findAll();
    }


}
