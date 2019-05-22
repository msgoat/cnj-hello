package group.msg.at.cloud.cloudtrain.core.entity;

import java.util.Objects;
import java.util.UUID;

/**
 * Simple {@code Entity} that represents a welcome messages.
 */
public class Message {

    private UUID id;

    private String code;

    private String text;

    public Message() {
        super();
    }

    public Message(UUID id, String code, String text) {
        this.id = id;
        this.code = code;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) &&
                code.equals(message.code) &&
                text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, text);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " { id : \"" + this.id + "\" }";
    }
}
