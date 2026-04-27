package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TerritoryTest {

	@Test
	void allArgsConstructor_setsAllFields() {
		Player owner = new Player(1, "Alice", "Red", 5);
		Territory territory = new Territory("Alaska", owner, 3, Continent.NORTH_AMERICA);

		assertEquals("Alaska", territory.getName());
		assertEquals(owner, territory.getOwner());
		assertEquals(3, territory.getArmyCount());
		assertEquals(Continent.NORTH_AMERICA, territory.getContinent());
	}

	@Test
	void setters_updateValues() {
		Territory territory = new Territory();
		Player owner = new Player(2, "Bob", "Blue", 4);

		territory.setName("Brazil");
		territory.setOwner(owner);
		territory.setArmyCount(6);
		territory.setContinent(Continent.SOUTH_AMERICA);

		assertEquals("Brazil", territory.getName());
		assertEquals(owner, territory.getOwner());
		assertEquals(6, territory.getArmyCount());
		assertEquals(Continent.SOUTH_AMERICA, territory.getContinent());
	}

	@Test
	void setOwner_allowsNull() {
		Territory territory = new Territory();

		territory.setOwner(null);

		assertNull(territory.getOwner());
	}

	@Test
	void setName_withNullOrBlank_throwsException() {
		Territory territory = new Territory();

		assertThrows(IllegalArgumentException.class, () -> territory.setName(null));
		assertThrows(IllegalArgumentException.class, () -> territory.setName(""));
		assertThrows(IllegalArgumentException.class, () -> territory.setName("   "));
	}

	@Test
	void setArmyCount_withNegativeValue_throwsException() {
		Territory territory = new Territory();

		assertThrows(IllegalArgumentException.class, () -> territory.setArmyCount(-1));
	}

	@Test
	void setContinent_withNull_throwsException() {
		Territory territory = new Territory();

		assertThrows(IllegalArgumentException.class, () -> territory.setContinent(null));
	}

	@Test
	void constructor_withInvalidArguments_throwsException() {
		Player owner = new Player(1, "Alice", "Red", 5);

		assertThrows(IllegalArgumentException.class, () -> new Territory(null, owner, 3, Continent.NORTH_AMERICA));
		assertThrows(IllegalArgumentException.class, () -> new Territory("", owner, 3, Continent.NORTH_AMERICA));
		assertThrows(IllegalArgumentException.class, () -> new Territory("Alaska", owner, -1, Continent.NORTH_AMERICA));
		assertThrows(IllegalArgumentException.class, () -> new Territory("Alaska", owner, 3, null));
	}
}
