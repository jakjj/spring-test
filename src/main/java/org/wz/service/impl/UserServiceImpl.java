package org.wz.service.impl;

import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Service;
import org.wz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUserService() {
        return " from UserService";
    }
}
