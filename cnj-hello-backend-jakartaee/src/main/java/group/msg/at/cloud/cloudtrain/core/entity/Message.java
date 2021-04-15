package group.msg.at.cloud.cloudtrain.core.entity;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Message other = (Message) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " { id : \"" + this.id + "\" }";
    }
}
