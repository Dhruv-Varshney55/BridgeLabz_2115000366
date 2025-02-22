package JUnit.AdvancedJUnitProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUppercase = false, hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasUppercase && hasDigit;
    }
}

public class PasswordValidatorTesting {
    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @AfterEach
    void tearDown() {
        passwordValidator = null;
    }

    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.isValid("StrongPass1"));
        assertTrue(passwordValidator.isValid("Valid123"));
    }

    @Test
    void testInvalidPasswordTooShort() {
        assertFalse(passwordValidator.isValid("Ab1"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(passwordValidator.isValid("weakpass1"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(passwordValidator.isValid("NoDigitHere"));
    }

    @Test
    void testInvalidPasswordNull() {
        assertFalse(passwordValidator.isValid(null));
    }
}