package JUnit.BasicJUnitProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnection {
    private boolean isConnected;

    public void connect() {
        isConnected = true;
    }

    public void disconnect() {
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }
}

public class DatabaseConnectionTesting {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected());
    }

    @Test
    void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected());
    }
}