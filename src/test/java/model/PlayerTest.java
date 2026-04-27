package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void allArgsConstructor_setsAllFields() {
		Player player = new Player(1, "Alice", "Red", 5);

		assertEquals(1, player.getId());
		assertEquals("Alice", player.getName());
		assertEquals("Red", player.getColor());
		assertEquals(5, player.getRemainingArmiesToPlace());
	}

	@Test
	void setters_updateValues() {
		Player player = new Player();

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
		Player player = new Player();

		assertThrows(IllegalArgumentException.class, () -> player.setId(-1));
	}

	@Test
	void setName_withNullOrBlank_throwsException() {
		Player player = new Player();

		assertThrows(IllegalArgumentException.class, () -> player.setName(null));
		assertThrows(IllegalArgumentException.class, () -> player.setName(""));
		assertThrows(IllegalArgumentException.class, () -> player.setName("   "));
	}

	@Test
	void setColor_withNullOrBlank_throwsException() {
		Player player = new Player();

		assertThrows(IllegalArgumentException.class, () -> player.setColor(null));
		assertThrows(IllegalArgumentException.class, () -> player.setColor(""));
		assertThrows(IllegalArgumentException.class, () -> player.setColor("   "));
	}

	@Test
	void setRemainingArmiesToPlace_withNegativeValue_throwsException() {
		Player player = new Player();

		assertThrows(IllegalArgumentException.class, () -> player.setRemainingArmiesToPlace(-1));
	}

	@Test
	void constructor_withInvalidArguments_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> new Player(-1, "Alice", "Red", 5));
		assertThrows(IllegalArgumentException.class, () -> new Player(1, "", "Red", 5));
		assertThrows(IllegalArgumentException.class, () -> new Player(1, "Alice", "", 5));
		assertThrows(IllegalArgumentException.class, () -> new Player(1, "Alice", "Red", -1));
	}
}
