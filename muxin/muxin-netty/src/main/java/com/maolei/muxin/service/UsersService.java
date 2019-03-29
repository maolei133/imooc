package com.maolei.muxin.service;

import com.maolei.muxin.pojo.Users;

public interface UsersService {

    boolean queryUserNameIsExist(String username);

    Users queryUsersForLogin(String username, String password);

    Users usersForRegist(Users users);
}
