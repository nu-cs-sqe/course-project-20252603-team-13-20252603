package service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import model.Continent;
import model.Player;
import model.Territory;

public class TerritoryAssignmentServiceTest {

	@Test
	void assignTerritoryToPlayer_setsOwnerCorrectly() {
		TerritoryAssignmentService service = new TerritoryAssignmentService();
		Player player = new Player(1, "Alice", "Red", 5);
		Territory territory = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

		service.assignTerritoryToPlayer(territory, player);

		assertSame(player, territory.getOwner());
	}

	@Test
	void assignTerritoryToPlayer_withNullTerritory_throwsException() {
		TerritoryAssignmentService service = new TerritoryAssignmentService();
		Player player = new Player(1, "Alice", "Red", 5);

		assertThrows(IllegalArgumentException.class, () -> service.assignTerritoryToPlayer(null, player));
	}

	@Test
	void assignTerritoryToPlayer_withNullPlayer_throwsException() {
		TerritoryAssignmentService service = new TerritoryAssignmentService();
		Territory territory = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

		assertThrows(IllegalArgumentException.class, () -> service.assignTerritoryToPlayer(territory, null));
	}
}
