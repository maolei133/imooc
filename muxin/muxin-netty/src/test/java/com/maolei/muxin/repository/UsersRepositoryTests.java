package com.maolei.muxin.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import com.maolei.muxin.ApplicationTests;
import com.maolei.muxin.pojo.Users;

public class UsersRepositoryTests extends ApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void save() {
        Users users = usersRepository.findOne(Example.of(Users.builder().username("admin").build()))
                .orElse(null);
        if (users == null) {
            usersRepository.save(Users.builder().username("admin").password("123456").faceImage("1")
                    .faceImageBig("2").nickname("超级管理员").qrcode("3").build());
        }
    }
}
