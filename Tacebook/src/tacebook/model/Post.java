/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.model;

import java.util.ArrayList;

/**
 * Esta clase implementa os atributos e métodos asociados ao obxecto publicación
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class Post {
    private String id;
    private String authorId;    // id do Profile autor
    private String content;
    private long createdAt;

    // Lista de comentarios (non se pasa no constructor)
    private final ArrayList<Comment> comments = new ArrayList<>();

    public Post(String id, String authorId, String content, long createdAt) {
        this.id = id;
        this.authorId = authorId;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getters / Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAtMillis() {
        return createdAt;
    }

    public void setCreatedAt(long createdAtMillis) {
        this.createdAt = createdAt;
    }

    // Métodos para comentarios
    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            comments.add(comment);
        }
    }

    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }

    @Override
    public String toString() {
        return "Post{id='" + id + "', authorId='" + authorId + "', createdAt=" + createdAt + "}";
    }
}
