package service;

import model.Player;
import model.Territory;
import model.GameState;
import model.GamePhase;



import java.util.List;

import org.easymock.EasyMock;
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

    // shouldInitializeTurnOrderAfterSetup()
//    @Test
//    void TC8_shouldInitializeTurnOrderAfterSetup() {
//        List<String> names = List.of("Adam", "Bob");
//        List<String> colors = List.of("Red", "Yellow");
//        GameSetupService gameSetupService = new GameSetupService();
//        GameState gameState1 = gameSetupService.orchestration(names, colors);
//
//        assertNotNull(gameState1.getTurnOrder());
//    }

//    @Test
//    void TC9_shouldSetCurrentPlayerToFirstPlayerInTurnOrder() {
//        List<String> names = List.of("Adam", "Bob");
//        List<String> colors = List.of("Red", "Yellow");
//        GameSetupService gameSetupService = new GameSetupService();
//        GameState gameState1 = gameSetupService.orchestration(names, colors);
//
//        Player player1_actual = gameState1.getCurrentPlayer();
//        Player player1_expected = gameState1.getPlayers().get(0);
//
//        assertEquals(player1_expected, player1_actual);
//        assertSame(player1_expected, player1_actual);
//    }

//    @Test
//    void TC10_shouldSetGamePhaseToReinforcementWhenSetupCompletes(){
//        List<String> names = List.of("Adam", "Bob");
//        List<String> colors = List.of("Red", "Yellow");
//        GameSetupService gameSetupService = new GameSetupService();
//        GameState gameState1 = gameSetupService.orchestration(names, colors);
//        assertEquals(GamePhase.REINFORCEMENT, gameState1.getCurrentPhase());
//    }

//    @Test
//    void TC11_shouldReturnFullyInitializedGameState() {
//        List<String> names = List.of("Adam", "Bob");
//        List<String> colors = List.of("Red", "Yellow");
//        GameSetupService gameSetupService = new GameSetupService();
//        GameState gameState1 = gameSetupService.orchestration(names, colors);
//        assertEquals(names.size(), gameState1.getPlayers().size());
//        assertNotNull(gameState1.getTerritories());
//        assertNotNull(gameState1.getPlayers());
//        assertEquals(42, gameState1.getTerritories().size());
//
//    }


}

