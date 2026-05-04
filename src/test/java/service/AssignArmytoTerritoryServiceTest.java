package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Continent;
import model.GameState;
import model.Player;
import model.Territory;

public class AssignArmytoTerritoryServiceTest {

    @Test
    public void assignArmyToTerritory_successfullyAddsArmiesAndDeductsPlayer() {
        GameState state = new GameState();
        Player player = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", player, 2, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        AssignArmytoTerritoryService.assignArmyToTerritory(state, player, "Alaska", 3);

        assertEquals(5, t.getArmyCount());
        assertEquals(2, player.getRemainingArmiesToPlace());
    }

    @Test
    public void assignArmyToTerritory_throwsWhenNotEnoughArmies() {
        GameState state = new GameState();
        Player player = new Player(1, "Alice", "red", 2);
        Territory t = new Territory("Alaska", player, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertThrows(IllegalArgumentException.class, () -> AssignArmytoTerritoryService.assignArmyToTerritory(state, player, "Alaska", 3));
    }

    @Test
    public void assignArmyToTerritory_throwsWhenPlayerDoesNotOwn() {
        GameState state = new GameState();
        Player owner = new Player(2, "Bob", "blue", 5);
        Player player = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", owner, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertThrows(IllegalArgumentException.class, () -> AssignArmytoTerritoryService.assignArmyToTerritory(state, player, "Alaska", 1));
    }
}
