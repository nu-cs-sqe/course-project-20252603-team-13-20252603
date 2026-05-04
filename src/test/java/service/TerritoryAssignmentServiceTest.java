package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Continent;
import model.GameState;
import model.Player;
import model.Territory;

public class TerritoryAssignmentServiceTest {

    // TerritoryService tests
    @Test
    public void findTerritoryByName_returnsTerritory_whenExists() {
        GameState state = new GameState();
        Territory t = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        Territory found = TerritoryService.findTerritoryByName(state, "Alaska");
        assertSame(t, found);
    }

    @Test
    public void findTerritoryByName_throws_whenNotFound() {
        GameState state = new GameState();
        state.setTerritories(List.of());

        assertThrows(IllegalArgumentException.class, () -> TerritoryService.findTerritoryByName(state, "Nowhere"));
    }

    @Test
    public void playerOwnsTerritory_trueWhenOwnerIdsMatch() {
        GameState state = new GameState();
        Player p = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", p, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertTrue(TerritoryService.playerOwnsTerritory(p, state, "Alaska"));
    }

    @Test
    public void playerOwnsTerritory_falseWhenOwnerNull() {
        GameState state = new GameState();
        Player p = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertFalse(TerritoryService.playerOwnsTerritory(p, state, "Alaska"));
    }

    @Test
    public void playerOwnsTerritory_falseWhenDifferentPlayer() {
        GameState state = new GameState();
        Player owner = new Player(2, "Bob", "blue", 3);
        Player p = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", owner, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertFalse(TerritoryService.playerOwnsTerritory(p, state, "Alaska"));
    }

    // TerritoryAssignmentService - assignArmyToTerritory tests
    @Test
    public void assignArmyToTerritory_successfullyAddsArmiesAndDeductsPlayer() {
        GameState state = new GameState();
        Player player = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", player, 2, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        TerritoryAssignmentService.assignArmyToTerritory(state, player, "Alaska", 3);

        assertEquals(5, t.getArmyCount());
        assertEquals(2, player.getRemainingArmiesToPlace());
    }

    @Test
    public void assignArmyToTerritory_throwsWhenNotEnoughArmies() {
        GameState state = new GameState();
        Player player = new Player(1, "Alice", "red", 2);
        Territory t = new Territory("Alaska", player, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertThrows(IllegalArgumentException.class, () -> TerritoryAssignmentService.assignArmyToTerritory(state, player, "Alaska", 3));
    }

    @Test
    public void assignArmyToTerritory_throwsWhenPlayerDoesNotOwn() {
        GameState state = new GameState();
        Player owner = new Player(2, "Bob", "blue", 5);
        Player player = new Player(1, "Alice", "red", 5);
        Territory t = new Territory("Alaska", owner, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertThrows(IllegalArgumentException.class, () -> TerritoryAssignmentService.assignArmyToTerritory(state, player, "Alaska", 1));
    }

    // TerritoryAssignmentService - assignTerritoryToPlayer tests
    @Test
    public void assignTerritoryToPlayer_setsOwnerCorrectly() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        Player player = new Player(1, "Alice", "Red", 5);
        Territory territory = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

        service.assignTerritoryToPlayer(territory, player);

        assertSame(player, territory.getOwner());
    }

    @Test
    public void assignTerritoryToPlayer_withNullTerritory_throwsException() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        Player player = new Player(1, "Alice", "Red", 5);

        assertThrows(IllegalArgumentException.class, () -> service.assignTerritoryToPlayer(null, player));
    }

    @Test
    public void assignTerritoryToPlayer_withNullPlayer_throwsException() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        Territory territory = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

        assertThrows(IllegalArgumentException.class, () -> service.assignTerritoryToPlayer(territory, null));
    }
}
