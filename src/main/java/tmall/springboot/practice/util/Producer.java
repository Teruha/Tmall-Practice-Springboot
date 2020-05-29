package tmall.springboot.practice.util;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;

public class Producer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String desName,String message){
        System.out.println("message:"+message);
        Destination destination = new ActiveMQQueue(desName);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
