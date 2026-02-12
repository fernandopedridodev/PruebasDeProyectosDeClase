/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.model;

import java.util.ArrayList;

/**
 * Esta clase implementa os atributos e métodos asociados ao obxecto perfil de usuario
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class Profile {
    private String id;
    private String name;
    private String password;
    private int numberOfPosts;

    // Lista de publicacións asociadas (non se pasa no constructor)
    private final ArrayList<Post> posts = new ArrayList<>();

    public Profile(String id, String name, String password, int numberOfPosts) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.numberOfPosts = numberOfPosts;
    }

    // Getters / Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    // Métodos para manipular a lista de posts
    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        if (post != null) {
            posts.add(post);
        }
    }

    public boolean removePost(Post post) {
        return posts.remove(post);
    }

    @Override
    public String toString() {
        return "Profile{id='" + id + "', name='" + name + "', numberOfPosts=" + numberOfPosts + "}";
    }
}
