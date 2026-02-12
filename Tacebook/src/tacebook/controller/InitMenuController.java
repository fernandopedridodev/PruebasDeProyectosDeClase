/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.controller;

import tacebook.model.Profile;
import tacebook.persistence.ProfileDB;
import tacebook.persistence.TacebookDB;
import tacebook.view.InitMenuView;

/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class InitMenuController {
    // Crear la vista en la declaración, tal y como pides
    private final InitMenuView myView = new InitMenuView(this);

    public static void main(String[] args) {
        new InitMenuController().init();
    }

    // Inicia a aplicación chamando repetidamente a showLoginMenu ata que devolva true
    private void init() {
        while (true) {
            boolean exit = myView.showLoginMenu();
            if (exit) break;
        }
    }

    // Intentar iniciar sesión: buscar perfil por nome e contrasinal e, se existe, abrir sesión
    public void login(String name, String password) {
        if (name == null || password == null) {
            myView.showLoginErrorMessage();
            return;
        }

        // Recuperar perfil (usamos 10 como número de posts mostrado por defecto)
        Profile profile = ProfileDB.findByNameAndPassword(name, password, 10);
        if (profile == null) {
            myView.showLoginErrorMessage();
            return;
        }

        // Crear controlador de perfil e abrir sesión con ese perfil
        ProfileController pc = new ProfileController();
        pc.openSession(profile);
    }

    // Mostrar o menú de rexistro (a vista fará a entrada e chamará createProfile)
    public void register() {
        myView.showRegisterMenu();
    }

    // Crear un novo perfil comprobando que o nome non estea en uso; se está en uso, pedir novo nome á vista.
    // Unha vez aceptado o nome, crear o Profile, gardalo e abrir sesión con el.
    public void createProfile(String name, String password, String status) {
        if (name == null || password == null) {
            return;
        }

        // Comprobar existencia de nome e pedir novo nome se está en uso
        while (true) {
            boolean inUse = false;
            if (TacebookDB.profiles != null) {
                for (Profile p : TacebookDB.profiles) {
                    if (p != null && name.equals(p.getName())) {
                        inUse = true;
                        break;
                    }
                }
            }
            if (!inUse) break;
            // Pedir novo nome á vista
            String newName = myView.showNewNameMenu();
            if (newName == null || newName.trim().isEmpty()) {
                // Se o usuario non proporciona un novo nome, cancelamos a creación
                return;
            }
            name = newName.trim();
        }

        // Crear o Profile (id null, numberOfPosts 0) e gardalo
        Profile profile = new Profile(null, name, password, 0);
        ProfileDB.save(profile);

        // Abrir sesión co novo perfil
        ProfileController pc = new ProfileController();
        pc.openSession(profile);
    }
}
