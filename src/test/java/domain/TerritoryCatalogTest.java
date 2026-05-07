package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Continent;

public class TerritoryCatalogTest {

	@Test
	void territoriesByContinent_containsAllContinents() {
		assertEquals(6, TerritoryCatalog.TERRITORIES_BY_CONTINENT.size());
		assertTrue(TerritoryCatalog.TERRITORIES_BY_CONTINENT.containsKey(Continent.NORTH_AMERICA));
		assertTrue(TerritoryCatalog.TERRITORIES_BY_CONTINENT.containsKey(Continent.SOUTH_AMERICA));
		assertTrue(TerritoryCatalog.TERRITORIES_BY_CONTINENT.containsKey(Continent.EUROPE));
		assertTrue(TerritoryCatalog.TERRITORIES_BY_CONTINENT.containsKey(Continent.AFRICA));
		assertTrue(TerritoryCatalog.TERRITORIES_BY_CONTINENT.containsKey(Continent.ASIA));
		assertTrue(TerritoryCatalog.TERRITORIES_BY_CONTINENT.containsKey(Continent.AUSTRALIA));
	}

	@Test
	void territoriesByContinent_hasExpectedTerritoryCounts() {
		assertEquals(9, TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(Continent.NORTH_AMERICA).size());
		assertEquals(4, TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(Continent.SOUTH_AMERICA).size());
		assertEquals(7, TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(Continent.EUROPE).size());
		assertEquals(6, TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(Continent.AFRICA).size());
		assertEquals(12, TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(Continent.ASIA).size());
		assertEquals(4, TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(Continent.AUSTRALIA).size());
	}

}
