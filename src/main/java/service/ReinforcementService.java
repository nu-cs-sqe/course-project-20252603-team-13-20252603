package service;


import model.GameState;
import model.Player;
import model.Territory;
import model.Continent;
import domain.TerritoryCatalog;

import java.util.List;
import java.util.stream.Collectors;

public class ReinforcementService {


    int calculateContinentBonus(Player player, GameState gameState){
        int total_bonuses = 0;
        Continent[] continents = Continent.values();
        for (int i = 0; i < 6; i++){
            Continent continent = continents[i];
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
    //Optional helpers:
    boolean controlsContinent(Player player, Continent continent, GameState gameState){
        List<Territory> territories = player.getControlledTerritories();
        List<Territory> new_territories = territories.stream().filter(territory -> territory.getContinent() == continent).collect(Collectors.toList());
        List<String> continent_territories = TerritoryCatalog.TERRITORIES_BY_CONTINENT.get(continent);
        if (new_territories.size() == continent_territories.size()) {
            return true;
        }
        else{
            return false;
        }
    }
}
