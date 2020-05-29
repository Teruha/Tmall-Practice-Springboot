package tmall.springboot.practice.util;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Destination;

public class pub {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    public void pulish(String desName,String message){
        Destination destination = new ActiveMQTopic(desName);
        System.out.println("发布动态"+message);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
