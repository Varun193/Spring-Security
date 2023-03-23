package com.boot.security.service;

import com.boot.security.entity.UserInfo;
import com.boot.security.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    //getting user info from DB and converting userInfo into UserDetails by giving username, password and authority
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = Optional.ofNullable(userInfoRepository.findByUsername(username));
        return userInfo.map(UserInfoUserDetails::new) //create a each obejct of UserInfoUserDetails
                .orElseThrow(() -> new UsernameNotFoundException("user not found" + username));
    }

}
