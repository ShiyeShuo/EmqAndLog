package com.ls.emqtest.entity;

import lombok.Data;

@Data
public class Message {
    String topic;
    String msg;
}
