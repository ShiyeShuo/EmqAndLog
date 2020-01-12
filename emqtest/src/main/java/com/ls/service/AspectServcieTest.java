package com.ls.service;

import com.ls.entity.Message;
import com.ls.entity.Role;

public interface AspectServcieTest {
    Message getMessage(Integer id);

    void addRole(Role role);
}
