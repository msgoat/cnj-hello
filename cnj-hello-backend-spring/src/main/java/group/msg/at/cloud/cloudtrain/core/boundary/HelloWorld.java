package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.entity.Message;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class HelloWorld {

    public Message getHelloMessage() {
        Message result = new Message(UUID.randomUUID());
        result.setCode("hello");
        result.setText("Welcome to Cloud Native Java with Spring Boot!");
        result.setLocale(Locale.GERMAN);
        return result;
    }
}
