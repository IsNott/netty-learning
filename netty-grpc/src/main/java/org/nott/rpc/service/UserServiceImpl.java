package org.nott.rpc.service;

import org.nott.rpc.model.User;

import java.util.UUID;

/**
 * @author Nott
 * @date 2024-7-23
 */

public class UserServiceImpl implements UserService{
    @Override
    public User getUser() {
        User user = new User(UUID.randomUUID().toString(),"测试",10);
        return user;
    }
}
