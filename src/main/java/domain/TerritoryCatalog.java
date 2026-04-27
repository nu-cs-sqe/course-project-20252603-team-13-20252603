package domain;

import java.util.List;
import java.util.Map;

import model.Continent;

public final class TerritoryCatalog {

	public static final Map<Continent, List<String>> TERRITORIES_BY_CONTINENT = Map.of(
		Continent.NORTH_AMERICA, List.of(
			"Alaska",
			"Northwest Territory",
			"Greenland",
			"Alberta",
			"Ontario",
			"Quebec",
			"Western United States",
			"Eastern United States",
			"Central America"
		),
		Continent.SOUTH_AMERICA, List.of(
			"Venezuela",
			"Peru",
			"Brazil",
			"Argentina"
		),
		Continent.EUROPE, List.of(
			"Iceland",
			"Scandinavia",
			"Ukraine",
			"Great Britain",
			"Northern Europe",
			"Western Europe",
			"Southern Europe"
		),
		Continent.AFRICA, List.of(
			"North Africa",
			"Egypt",
			"East Africa",
			"Congo",
			"South Africa",
			"Madagascar"
		),
		Continent.ASIA, List.of(
			"Ural",
			"Siberia",
			"Yakutsk",
			"Kamchatka",
			"Irkutsk",
			"Mongolia",
			"Japan",
			"Afghanistan",
			"China",
			"Middle East",
			"India",
			"Siam"
		),
		Continent.AUSTRALIA, List.of(
			"Indonesia",
			"New Guinea",
			"Western Australia",
			"Eastern Australia"
		)
	);

	private TerritoryCatalog() {
	}
}
