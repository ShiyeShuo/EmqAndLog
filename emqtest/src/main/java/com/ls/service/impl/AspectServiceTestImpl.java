package com.ls.service.impl;

import com.ls.entity.Message;
import com.ls.entity.Role;
import com.ls.service.AspectServcieTest;
import org.springframework.stereotype.Service;

@Service
public class AspectServiceTestImpl implements AspectServcieTest {
    @Override
    public Message getMessage(Integer id) {
        Message message = new Message();
        message.setId(id);
        message.setMsg("get message by id");
        message.setTopic("getMessageTopic");
        return message;
    }

    @Override
    public void addRole(Role role) {
        System.out.println("添加角色："+role.getRoleName());
    }
}
