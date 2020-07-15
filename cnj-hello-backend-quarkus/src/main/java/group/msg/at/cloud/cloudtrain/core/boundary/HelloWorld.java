package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.entity.Message;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Simple {@code Boundary} that returns welcome messages.
 */
@Dependent
@Transactional
public class HelloWorld {

    public Message getHelloMessage() {
        return new Message(UUID.randomUUID(), "hello", "Welcome to Cloud Native Java with MicroProfile!");
    }
}
