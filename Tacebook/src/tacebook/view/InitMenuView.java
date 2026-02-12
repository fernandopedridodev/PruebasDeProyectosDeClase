/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.view;

import java.util.Scanner;

/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class InitMenuView {

    private final Controller myController;

    public InitMenuView(Controller myController) {
        this.myController = myController;
    }

    public boolean showLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Menú de inicio ===");
        System.out.println("1) Iniciar sesión");
        System.out.println("2) Crear novo perfil");
        System.out.println("3) Saír");
        System.out.print("Escolla unha opción: ");

        String line = scanner.nextLine().trim();
        switch (line) {
            case "1":
                System.out.print("Usuario: ");
                String user = scanner.nextLine().trim();
                System.out.print("Contrasinal: ");
                String pwd = scanner.nextLine().trim();
                // Chamamos ao controlador para realizar o login
                myController.login(user, pwd);
                return false;
            case "2":
                // Chamamos ao controlador para rexistrar un novo perfil
                myController.register();
                return false;
            case "3":
                // Usuario quere saír
                return true;
            default:
                System.out.println("Opción non válida.");
                return false;

        }
    }

    public void showLoginErrorMessage() {
        System.out.println("Usuario ou contrasinal incorrectos.");

    }

    public void showRegisterMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome de usuario: ");
        String.name = scanner.nextLine().trim();
        System.out.print("Contrasinal: ");
        String password = scanner.nextLine().trim();

        System.out.print("Repita contrasinal: ");
        String password2 = scanner.nextLine().trim();

        if (!password.equals(password2)) {
            System.out.println("As contrasinais non coinciden.");
            return;
        }

        System.out.print("Estado: ");
        String status = scanner.nextLine().trim();

        // Chama ao controlador para crear o perfil
        myController.createProfile(name, password, status);
    }

    public String showNewNameMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("O nome de usuario introducido xa está en uso.");
        System.out.print("Introduza un novo nome: ");
        String newName = scanner.nextLine().trim();
        return newName;

    }
}
