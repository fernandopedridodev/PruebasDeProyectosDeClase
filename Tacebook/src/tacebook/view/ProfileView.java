/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.view;

import java.util.Scanner;
import tacebook.model.Profile;
import tacebook.view.InitMenuView;
/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class ProfileView {

    private int postsShown = 10;
    private final Object myController;

    public ProfileView(Object myController) {
        this.myController = myController;
    }

    public int getPostsShown() {
        return postsShown;

    }

    private void showProfileInfo(boolean ownProfile, Profile profile) {
        if (profile == null) {
            System.out.println("Perfil non dispoñible.");
            return;
        }

        String name = null;
        try {
            name = profile.getName();
        } catch (Exception ignored) {
        }

        String status = null;
        // Use reflection for status so the method compiles even if Profile doesn't have getStatus()
        try {
            java.lang.reflect.Method m = profile.getClass().getMethod("getStatus");
            Object s = m.invoke(profile);
            if (s != null) {
                status = s.toString();
            }
        } catch (Exception ignored) {
        }

        if (name == null) {
            name = "(sen nome)";
        }
        if (status == null) {
            status = "(sen estado)";
        }

        System.out.println("Nome: " + name);
        System.out.println("Estado: " + status);
    }

    private void changeStatus(boolean ownProfile, Scanner scanner, Profile profile) {

        if (ownProfile) {
            System.out.print("Novo estado: ");
            String newStatus = scanner.nextLine().trim();

            // Intentamos chamar ao método updateProfileStatus do controlador.
            // Primeiro, intentamos a sinatura máis simple: updateProfileStatus(String)
            try {
                java.lang.reflect.Method m = myController.getClass().getMethod("updateProfileStatus", String.class);
                m.invoke(myController, newStatus);
                return;
            } catch (Exception ignored) {
            }

            // Se non existe, probamos coa sinatura: updateProfileStatus(Profile, String)
            try {
                java.lang.reflect.Method m = myController.getClass().getMethod("updateProfileStatus", Profile.class, String.class);
                m.invoke(myController, profile, newStatus);
                return;
            } catch (Exception ignored) {
            }

            // Por último, probamos a sinatura sen parámetros: updateProfileStatus()
            try {
                java.lang.reflect.Method m = myController.getClass().getMethod("updateProfileStatus");
                m.invoke(myController);
                return;
            } catch (Exception ignored) {
            }

            // Se chegamos aquí, o controlador non ten un método coñecido para actualizar o estado.
            System.out.println("Non se pode actualizar o estado: o controlador non fornece updateProfileStatus.");
            return;
        }

        // ownProfile == false: opción non válida para outros perfís
        System.out.println("Esta opción só é válida na propia biografía.");
        try {
            // Volvemos a mostrar o menú do perfil (asumindo que existe o método)
            this.showProfileMenu();
        } catch (Exception ignored) {
        }

    }

    public void showProfileMenu(Profile profile) {
        // Mostrar información do perfil (asumimos sempre ownProfile = true por agora)
        showProfileInfo(true, profile);

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("1) Cambiar estado");
        System.out.println("2) Pechar sesión");
        System.out.print("Escolla unha opción: ");

        String option = scanner.nextLine().trim();
        switch (option) {
            case "1":
                // Chama a changeStatus con ownProfile = true
                changeStatus(true, scanner, profile);
                break;
            case "2":
                // Pechar sesión: non se fai nada, saimos do método
                break;
            default:
                System.out.println("Opción non válida.");
                break;
        }
    }
}
