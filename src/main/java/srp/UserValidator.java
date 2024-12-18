package srp;

import java.util.regex.Pattern;

public class UserValidator {

    // Validación de email
    public boolean isValidEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }

    // Validación de contraseña
    public boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}
