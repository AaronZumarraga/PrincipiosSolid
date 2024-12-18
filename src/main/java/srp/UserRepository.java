package srp;

public class UserRepository {

    // Método para simular la persistencia de los datos del usuario
    public void saveToDatabase(String email, String password) {
        System.out.println("Saving user to the database...");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);  // En la vida real, nunca guardarías la contraseña sin cifrado
    }
}
