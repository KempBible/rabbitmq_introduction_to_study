package com.example.rabbitmq_introduction_to_study;

import com.example.rabbitmq_introduction_to_study.Spring整合RibbitMQ.RabbitmqConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Send {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsgByTopics(){

        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        for (int i=0;i<5;i++){
            String message = "恭喜您，注册成功！userid="+i;
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,"topic.sms.email",message);
            System.out.println(" [x] Sent '" + message + "'");
        }

    }
}
