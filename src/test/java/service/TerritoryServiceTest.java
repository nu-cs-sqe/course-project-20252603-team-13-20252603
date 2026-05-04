package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Continent;
import model.GameState;
import model.Player;
import model.Territory;

public class TerritoryServiceTest {

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
}
