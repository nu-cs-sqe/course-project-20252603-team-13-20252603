package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

public class GameControllerTest {

@Test
void createGameStateFunctional_2_Players(){
    List<String> names = List.of("Adam", "Bob");
    List<String> colors = List.of("Red", "Yellow");
    GameController gameController1 = new GameController();
    GameState gameState1 = gameController1.createNewGame(names, colors);
    assertEquals(42, gameState1.getTerritories().size());
    assertEquals(2, gameState1.getPlayers().size());

    assertEquals(19, gameState1.getPlayers().get(0).getRemainingArmiesToPlace());
    assertEquals(19, gameState1.getPlayers().get(1).getRemainingArmiesToPlace());


}
@Test
void createGameStateFunctional_3_Players(){
    List<String> names = List.of("Adam", "Bob", "Chloe");
    List<String> colors = List.of("Red", "Yellow", "Blue");
    GameController gameController1 = new GameController();
    GameState gameState1 = gameController1.createNewGame(names, colors);
    assertEquals(42, gameState1.getTerritories().size());
    assertEquals(3, gameState1.getPlayers().size());

    assertEquals(21, gameState1.getPlayers().get(0).getRemainingArmiesToPlace());
    assertEquals(21, gameState1.getPlayers().get(1).getRemainingArmiesToPlace());
    assertEquals(21, gameState1.getPlayers().get(2).getRemainingArmiesToPlace());
}

@Test
void createGameStateFunctional_6_Players(){
    List<String> names = List.of("Adam", "Bob", "Chloe", "David", "Earl", "Faith");
    List<String> colors = List.of("Red", "Yellow", "Blue", "Green", "Orange", "Purple");
    GameController gameController1 = new GameController();
    GameState gameState1 = gameController1.createNewGame(names, colors);
    assertEquals(42, gameState1.getTerritories().size());
    assertEquals(6, gameState1.getPlayers().size());

    assertEquals(13, gameState1.getPlayers().get(0).getRemainingArmiesToPlace());
    assertEquals(13, gameState1.getPlayers().get(1).getRemainingArmiesToPlace());
    assertEquals(13, gameState1.getPlayers().get(2).getRemainingArmiesToPlace());
    assertEquals(13, gameState1.getPlayers().get(3).getRemainingArmiesToPlace());
    assertEquals(13, gameState1.getPlayers().get(4).getRemainingArmiesToPlace());
    assertEquals(13, gameState1.getPlayers().get(5).getRemainingArmiesToPlace());
}

// shouldInitializeTurnOrderAfterSetup()
@Test
void shouldInitializeTurnOrderAfterSetup() {
    List<String> names = List.of("Adam", "Bob");
    List<String> colors = List.of("Red", "Yellow");

}


// shouldSetCurrentPlayerToFirstPlayerInTurnOrder()

// shouldSetGamePhaseToReinforcementWhenSetupCompletes()

// shouldReturnFullyInitializedGameState()


}

