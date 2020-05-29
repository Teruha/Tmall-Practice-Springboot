package tmall.springboot.practice.util;

import org.springframework.jms.annotation.JmsListener;

public class Subscribe {
    @JmsListener(destination = "topic", containerFactory = "wqe")
    public void subscribe(String text){
        System.out.println("Received " + text);
    }
}
