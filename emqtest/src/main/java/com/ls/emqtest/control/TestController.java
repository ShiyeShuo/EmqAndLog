package com.ls.emqtest.control;

import com.ls.emqtest.client.MqttPushClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emqTest")
public class TestController
{
    @PostMapping("/sendToEmq")
    public void sendtoEmq(String top,String msg)
    {
        //MqttPushClient.publish(top,msg);

    }
}
