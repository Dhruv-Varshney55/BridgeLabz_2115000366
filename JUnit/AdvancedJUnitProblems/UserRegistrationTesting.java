package JUnit.AdvancedJUnitProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

class UserRegistration {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public void registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (password == null || !password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            throw new IllegalArgumentException("Password must be at least 8 characters, contain one uppercase letter, and one digit.");
        }
    }
}

public class UserRegistrationTesting {
    private final UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("DhruvVarshney", "dhruv.varshney@example.com", "Password123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "test@example.com", "Password123"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "test@example.com", "Password123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("DhruvVarshney", "invalid-email", "Password123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("DhruvVarshney", "dhruv.varshney@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("DhruvVarshney", "dhruv.varshney@example.com", "nouppercase1"));
    }
}