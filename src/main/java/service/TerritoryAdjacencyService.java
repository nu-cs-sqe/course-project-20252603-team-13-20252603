package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.TerritoryAdjacencyCatalog;
import domain.TerritoryCatalog;
import model.Continent;
import model.Territory;

public class TerritoryAdjacencyService {

	private final Map<String, Territory> territoryByName = new HashMap<>();

	public void initializeTerritoryAdjacency(List<Territory> territories) {
		if (territories == null) {
			throw new IllegalArgumentException("territories cannot be null");
		}

		territoryByName.clear();
		for (Territory territory : territories) {
			if (territory == null) {
				throw new IllegalArgumentException("territories cannot contain null values");
			}

			String name = territory.getName();
			if (territoryByName.containsKey(name)) {
				throw new IllegalArgumentException("duplicate territory name: " + name);
			}
			territoryByName.put(name, territory);
		}
	}

	public boolean areAdjacent(Territory territoryA, Territory territoryB) {
		if (territoryA == null || territoryB == null) {
			return false;
		}

		List<String> adjacentNames = TerritoryAdjacencyCatalog.ADJACENT_MAP.get(territoryA.getName());
		return adjacentNames != null && adjacentNames.contains(territoryB.getName());
	}

	public List<Territory> getAdjacentTerritories(Territory territory) {
		if (territory == null) {
			return List.of();
		}

		List<String> adjacentNames = TerritoryAdjacencyCatalog.ADJACENT_MAP.get(territory.getName());
		if (adjacentNames == null) {
			return List.of();
		}

		List<Territory> adjacentTerritories = new ArrayList<>();
		for (String adjacentName : adjacentNames) {
			Territory adjacentTerritory = territoryByName.get(adjacentName);
			if (adjacentTerritory != null) {
				adjacentTerritories.add(adjacentTerritory);
			}
		}
		return List.copyOf(adjacentTerritories);
	}

	public List<Territory> createAllTerritories() {
		List<Territory> territories = new ArrayList<>();
		for (Map.Entry<Continent, List<String>> entry : TerritoryCatalog.TERRITORIES_BY_CONTINENT.entrySet()) {
			Continent continent = entry.getKey();
			for (String name : entry.getValue()) {
				territories.add(new Territory(name, null, 0, continent));
			}
		}
		return List.copyOf(territories);
	}

	public Territory findByName(List<Territory> territories, String name) {
		if (territories == null) {
			throw new IllegalArgumentException("territories cannot be null");
		}
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name cannot be null or blank");
		}

		for (Territory territory : territories) {
			if (territory != null && territory.getName().equals(name)) {
				return territory;
			}
		}
		throw new IllegalArgumentException("territory not found: " + name);
	}
}
