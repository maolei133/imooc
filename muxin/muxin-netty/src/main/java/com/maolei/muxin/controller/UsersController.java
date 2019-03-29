package com.maolei.muxin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.maolei.muxin.pojo.Users;
import com.maolei.muxin.pojo.vo.UsersVO;
import com.maolei.muxin.service.UsersService;
import com.maolei.muxin.utils.JSONResult;
import com.maolei.muxin.utils.MD5Utils;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/registOrLogin")
    public JSONResult registOrLogin(@RequestBody Users users) throws Exception {
        String username = users.getUsername();
        String password = users.getPassword();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMap("用户名或密码不能为空...");
        }

        boolean userNameIsExist = usersService.queryUserNameIsExist(username);
        Users usersRes = null;
        if (userNameIsExist) {
            // 登陆
            usersRes = usersService.queryUsersForLogin(username, MD5Utils.getMD5Str(password));
            if (usersRes == null) {
                return JSONResult.errorMap("用户名或密码不正确...");
            }
        } else {
            // 注册
            users.setNickname(username);
            users.setPassword(MD5Utils.getMD5Str(password));
            usersRes = usersService.usersForRegist(users);
        }

        UsersVO vo = new UsersVO();
        BeanUtils.copyProperties(users, vo);
        return JSONResult.ok(vo);
    }

}
