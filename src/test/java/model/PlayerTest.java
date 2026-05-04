package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void allArgsConstructor_setsAllFields() {
		Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

		assertEquals(1, player.getId());
		assertEquals("Alice", player.getName());
		assertEquals("Red", player.getColor());
		assertEquals(5, player.getRemainingArmiesToPlace());
	}

	@Test
	void setters_updateValues() {
		Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

		player.setId(2);
		player.setName("Bob");
		player.setColor("Blue");
		player.setRemainingArmiesToPlace(7);

		assertEquals(2, player.getId());
		assertEquals("Bob", player.getName());
		assertEquals("Blue", player.getColor());
		assertEquals(7, player.getRemainingArmiesToPlace());
	}

	@Test
	void setId_withNegativeValue_throwsException() {
		Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

		assertThrows(IllegalArgumentException.class, () -> player.setId(-1));
	}

	@Test
	void setName_withNullOrBlank_throwsException() {
		Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

		assertThrows(IllegalArgumentException.class, () -> player.setName(null));
		assertThrows(IllegalArgumentException.class, () -> player.setName(""));
		assertThrows(IllegalArgumentException.class, () -> player.setName("   "));
	}

	@Test
	void setColor_withNullOrBlank_throwsException() {
		Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

		assertThrows(IllegalArgumentException.class, () -> player.setColor(null));
		assertThrows(IllegalArgumentException.class, () -> player.setColor(""));
		assertThrows(IllegalArgumentException.class, () -> player.setColor("   "));
	}

	@Test
	void setRemainingArmiesToPlace_withNegativeValue_throwsException() {
		Player player = new Player(1, "Alice", "Red", 5, new ArrayList<>());

		assertThrows(IllegalArgumentException.class, () -> player.setRemainingArmiesToPlace(-1));
	}

	@Test
	void constructor_withInvalidArguments_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> new Player(-1, "Alice", "Red", 5, new ArrayList<>()));
		assertThrows(IllegalArgumentException.class, () -> new Player(1, "", "Red", 5, new ArrayList<>()));
		assertThrows(IllegalArgumentException.class, () -> new Player(1, "Alice", "", 5, new ArrayList<>()));
		assertThrows(IllegalArgumentException.class, () -> new Player(1, "Alice", "Red", -1, new ArrayList<>()));
	}

	// Controlled Territory Tests


	@Test
	void parameterizedConstructor_initializesEmptyControlledTerritories() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		
		assertNotNull(player.getControlledTerritories());
		assertEquals(0, player.getControlledTerritoryCount());
	}

	@Test
	void addControlledTerritory_addsTerritory() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory territory = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		
		player.addControlledTerritory(territory);
		
		assertEquals(1, player.getControlledTerritoryCount());
		assertTrue(player.getControlledTerritories().contains(territory));
	}

	@Test
	void addControlledTerritory_withNullDoesNothing() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		
		player.addControlledTerritory(null);
		
		assertEquals(0, player.getControlledTerritoryCount());
	}

	@Test
	void addControlledTerritory_doesNotAddDuplicates() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory territory = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		
		player.addControlledTerritory(territory);
		player.addControlledTerritory(territory);
		
		assertEquals(1, player.getControlledTerritoryCount());
	}

	@Test
	void addControlledTerritory_addsMultipleTerritories() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		Territory t2 = new Territory("Brazil", player, 1, Continent.SOUTH_AMERICA);
		Territory t3 = new Territory("Japan", player, 1, Continent.ASIA);
		
		player.addControlledTerritory(t1);
		player.addControlledTerritory(t2);
		player.addControlledTerritory(t3);
		
		assertEquals(3, player.getControlledTerritoryCount());
		assertTrue(player.getControlledTerritories().contains(t1));
		assertTrue(player.getControlledTerritories().contains(t2));
		assertTrue(player.getControlledTerritories().contains(t3));
	}

	@Test
	void setControlledTerritories_replacesExistingList() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		Territory t2 = new Territory("Brazil", player, 1, Continent.SOUTH_AMERICA);
		Territory t3 = new Territory("Japan", player, 1, Continent.ASIA);
		
		List<Territory> newTerritories = new ArrayList<>();
		newTerritories.add(t1);
		newTerritories.add(t2);
		newTerritories.add(t3);
		
		player.setControlledTerritories(newTerritories);
		
		assertEquals(3, player.getControlledTerritoryCount());
		assertEquals(t1, player.getControlledTerritories().get(0));
		assertEquals(t2, player.getControlledTerritories().get(1));
		assertEquals(t3, player.getControlledTerritories().get(2));
	}

	@Test
	void setControlledTerritories_withNullCreatesEmptyList() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		player.addControlledTerritory(t1);
		
		assertEquals(1, player.getControlledTerritoryCount());
		
		player.setControlledTerritories(null);
		
		assertEquals(0, player.getControlledTerritoryCount());
		assertNotNull(player.getControlledTerritories());
	}

	@Test
	void setControlledTerritories_createsDeepCopy() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		Territory t2 = new Territory("Brazil", player, 1, Continent.SOUTH_AMERICA);
		
		List<Territory> originalList = new ArrayList<>();
		originalList.add(t1);
		originalList.add(t2);
		
		player.setControlledTerritories(originalList);
		
		// Modify original list
		originalList.add(new Territory("Japan", player, 1, Continent.ASIA));
		
		// Player's list should not be affected
		assertEquals(2, player.getControlledTerritoryCount());
	}

	@Test
	void setControlledTerritories_emptyListCreatesEmpty() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		player.addControlledTerritory(t1);
		
		assertEquals(1, player.getControlledTerritoryCount());
		
		player.setControlledTerritories(new ArrayList<>());
		
		assertEquals(0, player.getControlledTerritoryCount());
	}

	@Test
	void getControlledTerritories_returnsCorrectTerritories() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		Territory t2 = new Territory("Brazil", player, 1, Continent.SOUTH_AMERICA);
		
		player.addControlledTerritory(t1);
		player.addControlledTerritory(t2);
		
		List<Territory> controlled = player.getControlledTerritories();
		assertEquals(2, controlled.size());
		assertTrue(controlled.contains(t1));
		assertTrue(controlled.contains(t2));
	}

	@Test
	void getControlledTerritoryCount_returnsCorrectCount() {
		Player player = new Player(1, "Alice", "Red", 10, new ArrayList<>());
		assertEquals(0, player.getControlledTerritoryCount());
		
		Territory t1 = new Territory("Alaska", player, 1, Continent.NORTH_AMERICA);
		player.addControlledTerritory(t1);
		assertEquals(1, player.getControlledTerritoryCount());
		
		Territory t2 = new Territory("Brazil", player, 1, Continent.SOUTH_AMERICA);
		player.addControlledTerritory(t2);
		assertEquals(2, player.getControlledTerritoryCount());
	}
}
