package service;


import model.GameState;
import model.Player;
import model.Territory;
import model.Continent;
import domain.TerritoryCatalog;

import java.util.List;
import java.util.stream.Collectors;

public class ReinforcementService {

    /**
     * Calculates Continent Bonus: accumulates bonus for every continent a player controls entirety
     */
    int calculateContinentBonus(Player player, GameState gameState){
        int total_bonuses = 0;
        Continent[] continents = Continent.values();
        for (int i = 0; i < 6; i++){
            Continent continent = continents[i];
            // determine if the player controls every territory per continent
            boolean bonus_result = controlsContinent(player, continent, gameState);
            if (bonus_result) {
                if (continent == Continent.ASIA) {
                    total_bonuses += 7;
                }
                else if (continent == Continent.EUROPE) {
                    total_bonuses += 5;
                }
                else if (continent == Continent.NORTH_AMERICA) {
                    total_bonuses += 5;
                }
                else if (continent == Continent.SOUTH_AMERICA) {
                    total_bonuses += 2;
                }
                else if (continent == Continent.AUSTRALIA) {
                    total_bonuses += 2;
                }
                else if (continent == Continent.AFRICA) {
                    total_bonuses += 3;
                }
            }
        }

        return total_bonuses;
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
