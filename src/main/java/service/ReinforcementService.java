package service;

import model.Player;
import model.GameState;
import model.Territory;

import java.util.List;

public class ReinforcementService {


    void placeReinforcements(Player player, Territory territory, int armies, GameState gameState){
        boolean result = canPlaceReinforcements(player, territory, armies, gameState);
        System.out.println("result:" + result);
        if (result) {
            List<Territory> territories = player.getControlledTerritories();
            int territory_index = territories.indexOf(territory);
            Territory tr_found = territories.get(territory_index);
            int current_armies_unplaced = player.getRemainingArmiesToPlace();
            int new_remaining_armies = current_armies_unplaced - armies;
            int current_territories_placed = tr_found.getArmyCount();
            int new_territory_army = armies + current_territories_placed;
            tr_found.setArmyCount(new_territory_army);
            player.setRemainingArmiesToPlace(new_remaining_armies);
        }
        else {
            throw new IllegalArgumentException("Your army value or territory is not valid, please try again.");
        }

    }
    //Optional helpers:
    boolean canPlaceReinforcements(Player player, Territory territory, int armies, GameState gameState){

        List<Territory> territories = player.getControlledTerritories();
        int territory_index = territories.indexOf(territory);


        if (territory_index == -1){
            return false;
        }
        // int armies = tr_found.getArmyCount();
        if (player.getRemainingArmiesToPlace() < armies) {
            return false;
        }
        return true;
    }

}
