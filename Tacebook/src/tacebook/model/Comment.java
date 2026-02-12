/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.model;

/**
 * Esta clase implementa os atributos e métodos asociados ao obxecto comentario
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class Comment {
    private String id;
    private String postId;     // id do Post ao que pertence
    private String authorId;   // id do Profile que comenta
    private String content;    // contido do comentario
    private long createdAt;     // cando se crea o comentario

    
    // Construtor da clase
    public Comment(String id, String postId, String authorId, String content, long createdAt) {
        this.id = id;
        this.postId = postId;
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{id='" + id + "', postId='" + postId + "', authorId='" + authorId + "'}";
    }
}
