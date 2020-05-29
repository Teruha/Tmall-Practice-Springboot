package tmall.springboot.practice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

public class MycontainerFactory {
    @Bean(name = "wqe")
    public JmsListenerContainerFactory getJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory=new
                SimpleJmsListenerContainerFactory();
        simpleJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleJmsListenerContainerFactory.setPubSubDomain(true);
        return  simpleJmsListenerContainerFactory;
    }
}
