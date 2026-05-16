package service;


import model.GameState;
import model.Player;
import model.Territory;
import model.Continent;
import domain.TerritoryCatalog;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ReinforcementService {
    private static final Map<Continent, Integer> CONTINENT_BONUSES = Map.of(
            Continent.ASIA, 7,
            Continent.EUROPE, 5,
            Continent.NORTH_AMERICA, 5,
            Continent.SOUTH_AMERICA, 2,
            Continent.AUSTRALIA, 2,
            Continent.AFRICA, 3
    );
    /**
     * Calculates Continent Bonus: accumulates bonus for every continent a player controls entirety
     */
    int calculateContinentBonus(Player player, GameState gameState){
        int totalBonuses = 0;
        for (Continent continent : Continent.values()) {
            if (controlsContinent(player, continent, gameState)) {
                totalBonuses += CONTINENT_BONUSES.get(continent);
            }
        }
        return totalBonuses;
    }

    /**
     * Determines if a player controls territories of an entire continent
     */
    boolean controlsContinent(Player player, Continent continent, GameState gameState){
        // get all controlled territories
        List<Territory> territories = player.getControlledTerritories();
        // filter controlled territories by the input continent, and convert stream to a list
        List<Territory> new_territories = territories.stream().filter(territory -> territory.getContinent() == continent).collect(Collectors.toList());
        // get all territories in the provided continent
        List<String> continent_territories = TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(continent);
        if (new_territories.size() == continent_territories.size()) {
            return true;
        }
        else{
            return false;
        }
    }
}
