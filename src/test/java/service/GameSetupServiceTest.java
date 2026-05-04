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

// shouldInitializeTurnOrderAfterSetup()
@Test
void shouldInitializeTurnOrderAfterSetup() {
    List<String> names = List.of("Adam", "Bob");
    List<String> colors = List.of("Red", "Yellow");
    GameSetupService gameSetupService = new GameSetupService();
    GameState gameState1 = gameSetupService.orchestration(names, colors);

    assertNotNull(gameState1.getTurnOrder());
}

@Test
void shouldSetCurrentPlayerToFirstPlayerInTurnOrder() {
    List<String> names = List.of("Adam", "Bob");
    List<String> colors = List.of("Red", "Yellow");
    GameSetupService gameSetupService = new GameSetupService();
    GameState gameState1 = gameSetupService.orchestration(names, colors);

    Player player1_actual = gameState1.getCurrentPlayer();
    Player player1_expected = gameState1.getPlayers().get(0);

    assertEquals(player1_expected, player1_actual);
    assertSame(player1_expected, player1_actual);
}

@Test
void shouldSetGamePhaseToReinforcementWhenSetupCompletes(){
    List<String> names = List.of("Adam", "Bob");
    List<String> colors = List.of("Red", "Yellow");
    GameSetupService gameSetupService = new GameSetupService();
    GameState gameState1 = gameSetupService.orchestration(names, colors);
    assertEquals(GamePhase.REINFORCEMENT, gameState1.getCurrentPhase());
}

@Test
void shouldReturnFullyInitializedGameState() {
    List<String> names = List.of("Adam", "Bob");
    List<String> colors = List.of("Red", "Yellow");
    GameSetupService gameSetupService = new GameSetupService();
    GameState gameState1 = gameSetupService.orchestration(names, colors);
    assertEquals(names.size(), gameState1.getPlayers().size());
    assertEquals(42, gameState1.getTerritories().size());

}


}

