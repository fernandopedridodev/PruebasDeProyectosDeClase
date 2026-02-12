/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.model;

/**
 * Esta clase implementa os atributos e métodos asociados ao obxecto mensaxe
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class Message {
    private String id;
    private String senderId;
    private String receiverId;
    private String content;
    private long sentAtMillis;
    private boolean read;

    public Message(String id, String senderId, String receiverId, String content, long sentAtMillis, boolean read) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.sentAtMillis = sentAtMillis;
        this.read = read;
    }

    // Getters / Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSentAtMillis() {
        return sentAtMillis;
    }

    public void setSentAtMillis(long sentAtMillis) {
        this.sentAtMillis = sentAtMillis;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Message{id='" + id + "', senderId='" + senderId + "', receiverId='" + receiverId + "', read=" + read + "}";
    }
}
