package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Player p = new Player(1, "Alice", "red", 5, new ArrayList<>());
        Territory t = new Territory("Alaska", p, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertTrue(TerritoryService.playerOwnsTerritory(p, state, "Alaska"));
    }

    @Test
    public void playerOwnsTerritory_falseWhenOwnerNull() {
        GameState state = new GameState();
        Player p = new Player(1, "Alice", "red", 5, new ArrayList<>());
        Territory t = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertFalse(TerritoryService.playerOwnsTerritory(p, state, "Alaska"));
    }

    @Test
    public void playerOwnsTerritory_falseWhenDifferentPlayer() {
        GameState state = new GameState();
        Player owner = new Player(2, "Bob", "blue", 3, new ArrayList<>());
        Player p = new Player(1, "Alice", "red", 5, new ArrayList<>());
        Territory t = new Territory("Alaska", owner, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertFalse(TerritoryService.playerOwnsTerritory(p, state, "Alaska"));
    }

    // TerritoryAssignmentService - assignArmyToTerritory tests
    @Test
    public void assignArmyToTerritory_successfullyAddsArmiesAndDeductsPlayer() {
        GameState state = new GameState();
        Player player = new Player(1, "Alice", "red", 5, new ArrayList<>());
        Territory t = new Territory("Alaska", player, 2, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        TerritoryAssignmentService.assignArmyToTerritory(state, player, "Alaska", 3);

        assertEquals(5, t.getArmyCount());
        assertEquals(2, player.getRemainingArmiesToPlace());
    }

    @Test
    public void assignArmyToTerritory_throwsWhenNotEnoughArmies() {
        GameState state = new GameState();
        Player player = new Player(1, "Alice", "red", 2, new ArrayList<>());
        Territory t = new Territory("Alaska", player, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertThrows(IllegalArgumentException.class, () -> TerritoryAssignmentService.assignArmyToTerritory(state, player, "Alaska", 3));
    }

    @Test
    public void assignArmyToTerritory_throwsWhenPlayerDoesNotOwn() {
        GameState state = new GameState();
        Player owner = new Player(2, "Bob", "blue", 5, new ArrayList<>());
        Player player = new Player(1, "Alice", "red", 5, new ArrayList<>());
        Territory t = new Territory("Alaska", owner, 0, Continent.NORTH_AMERICA);
        state.setTerritories(List.of(t));

        assertThrows(IllegalArgumentException.class, () -> TerritoryAssignmentService.assignArmyToTerritory(state, player, "Alaska", 1));
    }

    // TerritoryAssignmentService - assignTerritoryToPlayer tests
    @Test
    public void assignTerritoryToPlayer_setsOwnerCorrectly() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());
        Territory territory = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

        service.assignTerritoryToPlayer(territory, player);

        assertSame(player, territory.getOwner());
    }

    @Test
    public void assignTerritoryToPlayer_withNullTerritory_throwsException() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

        assertThrows(IllegalArgumentException.class, () -> service.assignTerritoryToPlayer(null, player));
    }

    @Test
    public void assignTerritoryToPlayer_withNullPlayer_throwsException() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        Territory territory = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

        assertThrows(IllegalArgumentException.class, () -> service.assignTerritoryToPlayer(territory, null));
    }

    // assignTerritories() tests
    @Test
    public void assignTerritories_distributes42TerritoriesToPlayers() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        GameState state = new GameState();
        
        Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
        Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
        Player p3 = new Player(3, "Charlie", "green", 20, new ArrayList<>());
        Player p4 = new Player(4, "David", "yellow", 20, new ArrayList<>());
        state.setPlayers(List.of(p1, p2, p3, p4));

        service.assignTerritories(state);

        // Verify 42 territories are assigned
        assertEquals(42, state.getTerritories().size());
        
        // Verify all territories have exactly 1 army
        for (Territory t : state.getTerritories()) {
            assertEquals(1, t.getArmyCount(), "Territory " + t.getName() + " should have 1 army");
        }
    }

    @Test
    public void assignTerritories_noDuplicateTerritories() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        GameState state = new GameState();
        
        Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
        Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
        state.setPlayers(List.of(p1, p2));

        service.assignTerritories(state);

        // Verify no duplicate territory names
        Set<String> territoryNames = new HashSet<>();
        for (Territory t : state.getTerritories()) {
            assertFalse(territoryNames.contains(t.getName()), 
                "Territory " + t.getName() + " is assigned multiple times");
            territoryNames.add(t.getName());
        }
        assertEquals(42, territoryNames.size(), "Should have exactly 42 unique territories");
    }

    @Test
    public void assignTerritories_noPlayerHasSameTerritory() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        GameState state = new GameState();
        
        Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
        Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
        Player p3 = new Player(3, "Charlie", "green", 20, new ArrayList<>());
        Player p4 = new Player(4, "David", "yellow", 20, new ArrayList<>());
        state.setPlayers(List.of(p1, p2, p3, p4));

        service.assignTerritories(state);

        // Globally check that no territory is owned by multiple players
        Set<String> allAssignedTerritories = new HashSet<>();
        for (Player p : state.getPlayers()) {
            for (Territory t : p.getControlledTerritories()) {
                assertFalse(allAssignedTerritories.contains(t.getName()),
                    "Territory " + t.getName() + " is controlled by multiple players");
                allAssignedTerritories.add(t.getName());
                
                // Also verify the territory's owner matches the player
                assertEquals(p.getId(), t.getOwner().getId(),
                    "Territory " + t.getName() + " owner doesn't match player's controlled list");
            }
        }
        assertEquals(42, allAssignedTerritories.size(), "All 42 territories should be assigned");
    }

    @Test
        public void assignTerritories_correctDistributionFor2Players() {
            TerritoryAssignmentService service = new TerritoryAssignmentService();
            GameState state = new GameState();
        
            Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
            Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
            state.setPlayers(List.of(p1, p2));

            service.assignTerritories(state);

            // 42 territories / 2 players = 21 each
            assertEquals(21, p1.getControlledTerritoryCount(), "Player 1 should have 21 territories");
            assertEquals(21, p2.getControlledTerritoryCount(), "Player 2 should have 21 territories");
        }

    @Test
    public void assignTerritories_correctDistributionFor3Players() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        GameState state = new GameState();
        
        Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
        Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
        Player p3 = new Player(3, "Charlie", "green", 20, new ArrayList<>());
        state.setPlayers(List.of(p1, p2, p3));

        service.assignTerritories(state);

        // 42 territories / 3 players = 14 each
        assertEquals(14, p1.getControlledTerritoryCount(), "Player 1 should have 14 territories");
        assertEquals(14, p2.getControlledTerritoryCount(), "Player 2 should have 14 territories");
        assertEquals(14, p3.getControlledTerritoryCount(), "Player 3 should have 14 territories");
    }

	@Test
	public void assignTerritories_correctDistributionFor4Players() {
		TerritoryAssignmentService service = new TerritoryAssignmentService();
		GameState state = new GameState();

		Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
		Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
		Player p3 = new Player(3, "Charlie", "green", 20, new ArrayList<>());
		Player p4 = new Player(4, "David", "yellow", 20, new ArrayList<>());
		state.setPlayers(List.of(p1, p2, p3, p4));

		service.assignTerritories(state);

		// 42 territories / 4 players = 10 with remainder 2
		// So players 1 and 2 should have 11, players 3 and 4 should have 10
		assertEquals(11, p1.getControlledTerritoryCount(), "Player 1 should have 11 territories");
		assertEquals(11, p2.getControlledTerritoryCount(), "Player 2 should have 11 territories");
		assertEquals(10, p3.getControlledTerritoryCount(), "Player 3 should have 10 territories");
		assertEquals(10, p4.getControlledTerritoryCount(), "Player 4 should have 10 territories");
	}

        @Test
        public void assignTerritories_correctDistributionFor5Players() {
            TerritoryAssignmentService service = new TerritoryAssignmentService();
            GameState state = new GameState();
        
            Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
            Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
            Player p3 = new Player(3, "Charlie", "green", 20, new ArrayList<>());
            Player p4 = new Player(4, "David", "yellow", 20, new ArrayList<>());
            Player p5 = new Player(5, "Eve", "purple", 20, new ArrayList<>());
            state.setPlayers(List.of(p1, p2, p3, p4, p5));

            service.assignTerritories(state);

            // 42 territories / 5 players = 8 remainder 2
            // Round-robin: players 1 and 2 get 9, players 3, 4, 5 get 8
            assertEquals(9, p1.getControlledTerritoryCount(), "Player 1 should have 9 territories");
            assertEquals(9, p2.getControlledTerritoryCount(), "Player 2 should have 9 territories");
            assertEquals(8, p3.getControlledTerritoryCount(), "Player 3 should have 8 territories");
            assertEquals(8, p4.getControlledTerritoryCount(), "Player 4 should have 8 territories");
            assertEquals(8, p5.getControlledTerritoryCount(), "Player 5 should have 8 territories");
        }

        @Test
        public void assignTerritories_correctDistributionFor6Players() {
            TerritoryAssignmentService service = new TerritoryAssignmentService();
            GameState state = new GameState();
        
            Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
            Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
            Player p3 = new Player(3, "Charlie", "green", 20, new ArrayList<>());
            Player p4 = new Player(4, "David", "yellow", 20, new ArrayList<>());
            Player p5 = new Player(5, "Eve", "purple", 20, new ArrayList<>());
            Player p6 = new Player(6, "Frank", "orange", 20, new ArrayList<>());
            state.setPlayers(List.of(p1, p2, p3, p4, p5, p6));

            service.assignTerritories(state);

            // 42 territories / 6 players = 7 each
            assertEquals(7, p1.getControlledTerritoryCount(), "Player 1 should have 7 territories");
            assertEquals(7, p2.getControlledTerritoryCount(), "Player 2 should have 7 territories");
            assertEquals(7, p3.getControlledTerritoryCount(), "Player 3 should have 7 territories");
            assertEquals(7, p4.getControlledTerritoryCount(), "Player 4 should have 7 territories");
            assertEquals(7, p5.getControlledTerritoryCount(), "Player 5 should have 7 territories");
            assertEquals(7, p6.getControlledTerritoryCount(), "Player 6 should have 7 territories");
        }

        @Test
    public void assignTerritories_throwsWhenGameStateNull() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();

        assertThrows(NullPointerException.class, () -> service.assignTerritories(null));
    }

    @Test
    public void assignTerritories_throwsWhenNoPlayers() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        GameState state = new GameState();
        state.setPlayers(List.of());

        assertThrows(IllegalArgumentException.class, () -> service.assignTerritories(state));
    }

    @Test
    public void assignTerritories_eachTerritoryHasOwnerSet() {
        TerritoryAssignmentService service = new TerritoryAssignmentService();
        GameState state = new GameState();
        
        Player p1 = new Player(1, "Alice", "red", 20, new ArrayList<>());
        Player p2 = new Player(2, "Bob", "blue", 20, new ArrayList<>());
        state.setPlayers(List.of(p1, p2));

        service.assignTerritories(state);

        // Verify each territory has an owner
        for (Territory t : state.getTerritories()) {
            assertNotNull(t.getOwner(), "Territory " + t.getName() + " should have an owner");
            assertTrue(t.getOwner().getId() == 1 || t.getOwner().getId() == 2,
                "Territory " + t.getName() + " owner should be one of the players");
        }
    }
}
