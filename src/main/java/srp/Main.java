package srp;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de las clases necesarias
        UserValidator userValidator = new UserValidator();
        UserRepository userRepository = new UserRepository();
        NotificationService notificationService = new NotificationService();

        // Crear el UserManager con sus dependencias
        UserManager userManager = new UserManager(userValidator, userRepository, notificationService);

        // Probar con un usuario válido
        userManager.addUser("example@domain.com", "password123");

        // Probar con un usuario inválido
        userManager.addUser("invalid-email", "1234");
    }
}
