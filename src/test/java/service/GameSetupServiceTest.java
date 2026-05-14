package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameSetupServiceTest {

    @Test
    void TC1_ValidateMinimumSizeGame() {
        GameSetupService service = new GameSetupService();
        int playerCount = 2;
        assertDoesNotThrow(() -> service.validatePlayerCount(playerCount));
    }

    @Test
    void TC2_ValidateBelowMinimumSizeGame() {
        GameSetupService service = new GameSetupService();
        int playerCount = 1;
        assertThrows(IllegalArgumentException.class,
                () -> service.validatePlayerCount(playerCount));
    }

    @Test
    void TC3_ValidateMaximumSizeGame() {
        GameSetupService service = new GameSetupService();
        int playerCount = 6;
        assertDoesNotThrow(() -> service.validatePlayerCount(playerCount));
    }

    @Test
    void TC4_ValidateAboveMaximumSizeGame() {
        GameSetupService service = new GameSetupService();
        int playerCount = 7;
        assertThrows(IllegalArgumentException.class,
                () -> service.validatePlayerCount(playerCount));
    }

    @Test
    void TC5_ValidateINT_MAX() {
        GameSetupService service = new GameSetupService();
        int playerCount = Integer.MAX_VALUE;
        assertThrows(IllegalArgumentException.class,
                () -> service.validatePlayerCount(playerCount));
    }

    @Test
    void TC6_ValidateINT_MIN() {
        GameSetupService service = new GameSetupService();
        int playerCount = Integer.MIN_VALUE;
        assertThrows(IllegalArgumentException.class,
                () -> service.validatePlayerCount(playerCount));
    }

    @Test
    void TC7_ValidateInRangeOfValidGame() {
        GameSetupService service = new GameSetupService();
        int playerCount = 4;
        assertDoesNotThrow(() -> service.validatePlayerCount(playerCount));
    }

}
