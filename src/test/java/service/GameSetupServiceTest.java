package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameSetupServiceTest {

    @Test
    void TC1_ValidateMinimumSizeGame() {
        GameSetupService service = new GameSetupService();
        assertTrue(service.validatePlayerCount(2));
    }
}
