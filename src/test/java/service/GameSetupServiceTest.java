package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameSetupServiceTest {

    @Test
    void TC1_ValidateMinimumSizeGame() {
        GameSetupService service = new GameSetupService();
        assertTrue(service.validatePlayerCount(2));
    }

    @Test
    void TC2_ValidateBelowMinimumSizeGame() {
        GameSetupService service = new GameSetupService();
        int playerCount = 1;
        assertFalse(service.validatePlayerCount(playerCount));
    }

}
