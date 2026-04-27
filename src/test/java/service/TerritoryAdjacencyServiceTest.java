package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import domain.TerritoryAdjacencyCatalog;
import model.Continent;
import model.Territory;

public class TerritoryAdjacencyServiceTest {

	@Test
	void areAdjacent_returnsTrueForKnownAdjacentTerritories() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaska = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
		Territory alberta = new Territory("Alberta", null, 0, Continent.NORTH_AMERICA);

		assertTrue(service.areAdjacent(alaska, alberta));
	}

	@Test
	void areAdjacent_isBidirectionalForKnownNeighborPair() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaska = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
		Territory alberta = new Territory("Alberta", null, 0, Continent.NORTH_AMERICA);

		assertTrue(service.areAdjacent(alaska, alberta));
		assertTrue(service.areAdjacent(alberta, alaska));
	}

	@Test
	void areAdjacent_returnsFalseForNonAdjacentTerritories() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaska = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
		Territory brazil = new Territory("Brazil", null, 0, Continent.SOUTH_AMERICA);

		assertFalse(service.areAdjacent(alaska, brazil));
	}

	@Test
	void areAdjacent_returnsFalseWhenComparingSameTerritory() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaska = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

		assertFalse(service.areAdjacent(alaska, alaska));
	}

	@Test
	void initializeTerritoryAdjacency_withNullList_throwsException() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();

		assertThrows(IllegalArgumentException.class, () -> service.initializeTerritoryAdjacency(null));
	}

	@Test
	void initializeTerritoryAdjacency_withDuplicateTerritoryName_throwsException() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaskaOne = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
		Territory alaskaTwo = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

		assertThrows(IllegalArgumentException.class,
			() -> service.initializeTerritoryAdjacency(List.of(alaskaOne, alaskaTwo)));
	}

	@Test
	void getAdjacentTerritories_returnsInitializedNeighborsOnly() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaska = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);
		Territory northwestTerritory = new Territory("Northwest Territory", null, 0, Continent.NORTH_AMERICA);
		Territory alberta = new Territory("Alberta", null, 0, Continent.NORTH_AMERICA);
		Territory kamchatka = new Territory("Kamchatka", null, 0, Continent.ASIA);

		service.initializeTerritoryAdjacency(List.of(alaska, northwestTerritory, alberta, kamchatka));

		List<Territory> adjacent = service.getAdjacentTerritories(alaska);
		assertEquals(3, adjacent.size());
		assertTrue(adjacent.contains(northwestTerritory));
		assertTrue(adjacent.contains(alberta));
		assertTrue(adjacent.contains(kamchatka));
	}

	@Test
	void getAdjacentTerritories_doesNotContainDuplicateEntries() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();
		service.initializeTerritoryAdjacency(allTerritories);

		Territory ontario = service.findByName(allTerritories, "Ontario");
		List<Territory> adjacent = service.getAdjacentTerritories(ontario);
		Set<Territory> unique = new HashSet<>(adjacent);

		assertEquals(unique.size(), adjacent.size());
	}

	@Test
	void getAdjacentTerritories_hasAdjacencyDefinedForAllFortyTwoTerritories() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();
		service.initializeTerritoryAdjacency(allTerritories);

		assertEquals(42, allTerritories.size());
		for (Territory territory : allTerritories) {
			List<Territory> adjacent = service.getAdjacentTerritories(territory);
			List<String> expectedNames = TerritoryAdjacencyCatalog.ADJACENT_MAP.get(territory.getName());

			assertTrue(expectedNames != null && !expectedNames.isEmpty());
			assertEquals(expectedNames.size(), adjacent.size());
		}
	}

	@Test
	void createAllTerritories_assignsContinentFromTerritoryCatalog() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();

		assertEquals(Continent.NORTH_AMERICA, service.findByName(allTerritories, "Alaska").getContinent());
		assertEquals(Continent.SOUTH_AMERICA, service.findByName(allTerritories, "Brazil").getContinent());
		assertEquals(Continent.EUROPE, service.findByName(allTerritories, "Ukraine").getContinent());
		assertEquals(Continent.AFRICA, service.findByName(allTerritories, "Egypt").getContinent());
		assertEquals(Continent.ASIA, service.findByName(allTerritories, "India").getContinent());
		assertEquals(Continent.AUSTRALIA, service.findByName(allTerritories, "Indonesia").getContinent());
	}

	@Test
	void createAllTerritories_returnsAll42UniqueTerritories() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();
		Set<String> names = new HashSet<>();

		for (Territory territory : allTerritories) {
			names.add(territory.getName());
		}

		assertEquals(42, allTerritories.size());
		assertEquals(42, names.size());
	}

	@Test
	void findByName_returnsMatchingTerritory() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();

		Territory result = service.findByName(allTerritories, "Alaska");

		assertEquals("Alaska", result.getName());
		assertEquals(Continent.NORTH_AMERICA, result.getContinent());
	}

	@Test
	void findByName_withNullOrBlankName_throwsException() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();

		assertThrows(IllegalArgumentException.class, () -> service.findByName(allTerritories, null));
		assertThrows(IllegalArgumentException.class, () -> service.findByName(allTerritories, ""));
		assertThrows(IllegalArgumentException.class, () -> service.findByName(allTerritories, "   "));
	}

	@Test
	void findByName_withMissingName_throwsException() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		List<Territory> allTerritories = service.createAllTerritories();

		assertThrows(IllegalArgumentException.class, () -> service.findByName(allTerritories, "Atlantis"));
	}

	@Test
	void findByName_withNullTerritoryList_throwsException() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();

		assertThrows(IllegalArgumentException.class, () -> service.findByName(null, "Alaska"));
	}

	@Test
	void getAdjacentTerritories_whenNotInitialized_returnsEmptyList() {
		TerritoryAdjacencyService service = new TerritoryAdjacencyService();
		Territory alaska = new Territory("Alaska", null, 0, Continent.NORTH_AMERICA);

		assertTrue(service.getAdjacentTerritories(alaska).isEmpty());
	}
}
