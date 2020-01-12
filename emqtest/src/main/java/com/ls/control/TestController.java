package com.ls.control;

import com.ls.aspect.anno.ServiceLog;
import com.ls.client.MqttPushClient;
import com.ls.entity.Message;
import com.ls.enums.TestModelEnum;
import com.ls.enums.TestOperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emqTest")
public class TestController
{
    @Autowired
    private MqttPushClient mqttPushClient;
    @RequestMapping(value ="/sendToEmq")
    public void sendtoEmq(@RequestBody Message data)
    {
        mqttPushClient.publish(data.getTopic(),data.getMsg());

    }
}
