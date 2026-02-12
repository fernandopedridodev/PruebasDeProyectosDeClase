/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.controller;

import tacebook.model.Profile;
import tacebook.persistence.ProfileDB;
import tacebook.view.ProfileView;

/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class ProfileController {

    // Crear a vista na declaración como pides
    private final ProfileView myView = new ProfileView(this);

    // Perfil da sesión con getter público
    private Profile sessionProfile;

    public Profile getSessionProfile() {
        return sessionProfile;
    }

    // Obtén o número de publicacións a mostrar desde a vista
    public int getPostsShown() {
        return myView.getPostsShown();
    }

    // Obtén o obxecto do perfil da sesión usando ProfileDB e mostra o menú do perfil para el
    public void reloadProfile() {
        if (sessionProfile == null) return;
        Profile fresh = ProfileDB.findByName(sessionProfile.getName(), myView.getPostsShown());
        if (fresh == null) return;
        this.sessionProfile = fresh;
        myView.showProfileMenu(fresh);
    }

    // Abre sesión gardando o perfil e chamando á vista
    public void openSession(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
        myView.showProfileMenu(sessionProfile);
    }

    // Actualiza o estado do perfil, garda o cambio e recarga o perfil
    public void updateProfileStatus(String newStatus) {
          if (sessionProfile == null) return;

        boolean updated = false;

        // Intentar llamar a setStatus(String) si existe
        try {
            java.lang.reflect.Method m = sessionProfile.getClass().getMethod("setStatus", String.class);
            m.invoke(sessionProfile, newStatus);
            updated = true;
        } catch (NoSuchMethodException nsme) {
            // No existe el método; lo manejamos abajo intentando acceder al campo directamente
        } catch (Exception ignored) {
        }

        // Si no hay setStatus, intentar asignar directamente al campo "status" si existe
        if (!updated) {
            try {
                java.lang.reflect.Field f = sessionProfile.getClass().getDeclaredField("status");
                f.setAccessible(true);
                f.set(sessionProfile, newStatus);
                updated = true;
            } catch (Exception ignored) {
            }
        }

        // Guardar el perfil (aunque no se haya podido actualizar el estado vía reflexión)
        ProfileDB.save(sessionProfile);

        // Recargar y mostrar el perfil
        reloadProfile();
    }
}
