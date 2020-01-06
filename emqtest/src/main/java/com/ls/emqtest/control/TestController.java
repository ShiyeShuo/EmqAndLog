package com.ls.emqtest.control;

import com.ls.emqtest.client.MqttPushClient;
import com.ls.emqtest.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emqTest")
public class TestController
{
    @Autowired
    MqttPushClient mqttPushClient;
    @RequestMapping("/sendToEmq")
    public void sendtoEmq(Message data)
    {
        mqttPushClient.publish(data.getTopic(),data.getMsg());

    }
}
