/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.persistence;

import tacebook.model.Profile;

/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class ProfileDB {

    // Método que atopa perfil polo nome de usuario
    public static Profile findByName(String name, int numberOfPosts) {
        if (name == null) {
            return null;
        }
        if (TacebookDB.profiles == null) {
            return null;
        }
        /*
        Bucle for mellorado que recorre o arraylist de perfiles gardados e os 
        atopa cando son iguais ao que se introduce.        
         */
        for (Profile p : TacebookDB.profiles) {
            if (p != null && name.equals(p.getName())) {
                // Ajustar numberOfPosts antes de devolver
                p.setNumberOfPosts(numberOfPosts);
                return p;
            }
        }
        return null;
    }
    // Método que debe atopar un perfil por nome e contrasinal

    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts) {
        if (name == null || password == null) {
            return null;
        }
        if (TacebookDB.profiles == null) {
            return null;
        }
        // Recorremos o arraylist cun bucle for mellorado que retorna perfil se contrasinal é correcta
        for (Profile p : TacebookDB.profiles) {
            if (p != null && name.equals(p.getName())) {
                String storedPwd = p.getPassword();
                if (storedPwd != null && storedPwd.equals(password)) {
                    // Ajustar numberOfPosts antes de devolver
                    p.setNumberOfPosts(numberOfPosts);
                    return p;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static void save(Profile profile) {
        if (profile == null) {
            throw new IllegalArgumentException("O perfil non pode ser null");
        }
        String name = profile.getName();
        if (name == null) {
            throw new IllegalArgumentException("O nome do perfil non pode ser null");
        }
        if (TacebookDB.profiles == null) {
            return;
        }

        for (int i = 0; i < TacebookDB.profiles.size(); i++) {
            Profile p = TacebookDB.profiles.get(i);
            if (p != null && name.equals(p.getName())) {
                TacebookDB.profiles.set(i, profile);
                return;
            }
        }
        TacebookDB.profiles.add(profile);
    }

    public static void update(Profile profile) {

    }
}
