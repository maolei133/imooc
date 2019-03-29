package com.maolei.muxin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.maolei.muxin.pojo.Users;
import com.maolei.muxin.repository.UsersRepository;
import com.maolei.muxin.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean queryUserNameIsExist(String username) {
        Users users = usersRepository
                .findOne(Example.of(Users.builder().username(username).build())).orElse(null);
        return users == null ? false : true;
    }

    @Override
    public Users queryUsersForLogin(String username, String password) {
        Users users = usersRepository
                .findOne(Example.of(Users.builder().username(username).password(password).build()))
                .orElse(null);
        return users;
    }

    @Override
    public Users usersForRegist(Users users) {
        users.setFaceImage("");
        users.setFaceImageBig("");
        users.setQrcode("");
        return usersRepository.save(users);
    }

}
