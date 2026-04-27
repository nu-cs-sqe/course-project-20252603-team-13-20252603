package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TerritoryAdjacencyCatalogTest {

	@Test
	void adjacentMap_containsAllTerritories() {
		assertEquals(42, TerritoryAdjacencyCatalog.ADJACENT_MAP.size());
	}

	@Test
	void adjacentMap_containsExpectedNeighborsForKeyTerritories() {
		assertEquals(List.of("Northwest Territory", "Alberta", "Kamchatka"),
			TerritoryAdjacencyCatalog.ADJACENT_MAP.get("Alaska"));
		assertEquals(List.of("Siam", "New Guinea", "Western Australia"),
			TerritoryAdjacencyCatalog.ADJACENT_MAP.get("Indonesia"));
		assertTrue(TerritoryAdjacencyCatalog.ADJACENT_MAP.get("Brazil").contains("North Africa"));
	}

}
