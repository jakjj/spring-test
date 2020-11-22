package org.wz.controller;

import org.wz.annotation.MyAutoWired;
import org.wz.service.UserService;

public class UserController {

    @MyAutoWired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
