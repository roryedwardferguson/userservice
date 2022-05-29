package com.rory.userservice.dao;

import com.rory.userservice.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDao extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
