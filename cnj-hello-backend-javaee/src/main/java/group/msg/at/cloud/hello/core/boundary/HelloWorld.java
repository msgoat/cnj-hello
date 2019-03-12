package group.msg.at.cloud.hello.core.boundary;

import group.msg.at.cloud.hello.core.entity.Message;

import javax.ejb.Stateless;
import java.util.UUID;

/**
 * Simple {@code Boundary} that returns welcome messages.
 */
@Stateless
public class HelloWorld {

    public Message getHelloMessage() {
        return new Message(UUID.randomUUID(), "hello", "Welcome to Cloud Native Java with Java EE!");
    }
}
