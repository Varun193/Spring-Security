package com.boot.security.repo;

import com.boot.security.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUsername(String username);
}
