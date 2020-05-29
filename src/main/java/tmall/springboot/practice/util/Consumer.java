package tmall.springboot.practice.util;

import org.springframework.jms.annotation.JmsListener;

public class Consumer {
    @JmsListener(destination = "consumer")
    public void receive(String string){
        System.out.println("收到："+string);
    }
}
