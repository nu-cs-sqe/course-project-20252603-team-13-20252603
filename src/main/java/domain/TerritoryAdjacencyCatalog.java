package domain;

import java.util.List;
import java.util.Map;

public final class TerritoryAdjacencyCatalog {

	public static final Map<String, List<String>> ADJACENT_MAP = Map.ofEntries(
		// NORTH AMERICA
		Map.entry("Alaska", List.of(
			"Northwest Territory",
			"Alberta",
			"Kamchatka"
		)),
		Map.entry("Northwest Territory", List.of(
			"Alaska",
			"Alberta",
			"Ontario",
			"Greenland"
		)),
		Map.entry("Greenland", List.of(
			"Northwest Territory",
			"Ontario",
			"Quebec",
			"Iceland"
		)),
		Map.entry("Alberta", List.of(
			"Alaska",
			"Northwest Territory",
			"Ontario",
			"Western United States"
		)),
		Map.entry("Ontario", List.of(
			"Northwest Territory",
			"Greenland",
			"Alberta",
			"Quebec",
			"Western United States",
			"Eastern United States"
		)),
		Map.entry("Quebec", List.of(
			"Ontario",
			"Greenland",
			"Eastern United States"
		)),
		Map.entry("Western United States", List.of(
			"Alberta",
			"Ontario",
			"Eastern United States",
			"Central America"
		)),
		Map.entry("Eastern United States", List.of(
			"Ontario",
			"Quebec",
			"Western United States",
			"Central America"
		)),
		Map.entry("Central America", List.of(
			"Western United States",
			"Eastern United States",
			"Venezuela"
		)),

		// SOUTH AMERICA
		Map.entry("Venezuela", List.of(
			"Central America",
			"Peru",
			"Brazil"
		)),
		Map.entry("Peru", List.of(
			"Venezuela",
			"Brazil",
			"Argentina"
		)),
		Map.entry("Brazil", List.of(
			"Venezuela",
			"Peru",
			"Argentina",
			"North Africa"
		)),
		Map.entry("Argentina", List.of(
			"Peru",
			"Brazil"
		)),

		// EUROPE
		Map.entry("Iceland", List.of(
			"Greenland",
			"Great Britain",
			"Scandinavia"
		)),
		Map.entry("Scandinavia", List.of(
			"Iceland",
			"Great Britain",
			"Northern Europe",
			"Ukraine"
		)),
		Map.entry("Ukraine", List.of(
			"Scandinavia",
			"Northern Europe",
			"Southern Europe",
			"Ural",
			"Afghanistan",
			"Middle East"
		)),
		Map.entry("Great Britain", List.of(
			"Iceland",
			"Scandinavia",
			"Northern Europe",
			"Western Europe"
		)),
		Map.entry("Northern Europe", List.of(
			"Great Britain",
			"Scandinavia",
			"Ukraine",
			"Western Europe",
			"Southern Europe"
		)),
		Map.entry("Western Europe", List.of(
			"Great Britain",
			"Northern Europe",
			"Southern Europe",
			"North Africa"
		)),
		Map.entry("Southern Europe", List.of(
			"Western Europe",
			"Northern Europe",
			"Ukraine",
			"North Africa",
			"Egypt",
			"Middle East"
		)),

		// AFRICA
		Map.entry("North Africa", List.of(
			"Brazil",
			"Western Europe",
			"Southern Europe",
			"Egypt",
			"East Africa",
			"Congo"
		)),
		Map.entry("Egypt", List.of(
			"North Africa",
			"Southern Europe",
			"Middle East",
			"East Africa"
		)),
		Map.entry("East Africa", List.of(
			"Egypt",
			"North Africa",
			"Congo",
			"South Africa",
			"Madagascar",
			"Middle East"
		)),
		Map.entry("Congo", List.of(
			"North Africa",
			"East Africa",
			"South Africa"
		)),
		Map.entry("South Africa", List.of(
			"Congo",
			"East Africa",
			"Madagascar"
		)),
		Map.entry("Madagascar", List.of(
			"East Africa",
			"South Africa"
		)),

		// ASIA
		Map.entry("Ural", List.of(
			"Ukraine",
			"Siberia",
			"China",
			"Afghanistan"
		)),
		Map.entry("Siberia", List.of(
			"Ural",
			"Yakutsk",
			"Irkutsk",
			"Mongolia",
			"China"
		)),
		Map.entry("Yakutsk", List.of(
			"Siberia",
			"Irkutsk",
			"Kamchatka"
		)),
		Map.entry("Kamchatka", List.of(
			"Alaska",
			"Yakutsk",
			"Irkutsk",
			"Mongolia",
			"Japan"
		)),
		Map.entry("Irkutsk", List.of(
			"Siberia",
			"Yakutsk",
			"Kamchatka",
			"Mongolia"
		)),
		Map.entry("Mongolia", List.of(
			"Siberia",
			"Irkutsk",
			"Kamchatka",
			"Japan",
			"China"
		)),
		Map.entry("Japan", List.of(
			"Kamchatka",
			"Mongolia"
		)),
		Map.entry("Afghanistan", List.of(
			"Ukraine",
			"Ural",
			"China",
			"India",
			"Middle East"
		)),
		Map.entry("China", List.of(
			"Ural",
			"Siberia",
			"Mongolia",
			"Afghanistan",
			"India",
			"Siam"
		)),
		Map.entry("Middle East", List.of(
			"Ukraine",
			"Southern Europe",
			"Egypt",
			"East Africa",
			"Afghanistan",
			"India"
		)),
		Map.entry("India", List.of(
			"Middle East",
			"Afghanistan",
			"China",
			"Siam"
		)),
		Map.entry("Siam", List.of(
			"India",
			"China",
			"Indonesia"
		)),

		// AUSTRALIA
		Map.entry("Indonesia", List.of(
			"Siam",
			"New Guinea",
			"Western Australia"
		)),
		Map.entry("New Guinea", List.of(
			"Indonesia",
			"Western Australia",
			"Eastern Australia"
		)),
		Map.entry("Western Australia", List.of(
			"Indonesia",
			"New Guinea",
			"Eastern Australia"
		)),
		Map.entry("Eastern Australia", List.of(
			"New Guinea",
			"Western Australia"
		))
	);

	private TerritoryAdjacencyCatalog() {
	}
}
