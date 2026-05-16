package service;

import model.Player;
import model.GameState;
import model.Territory;

import java.util.List;

public class ReinforcementService {

    /**
     * Validates and performs placement of reinforcements, throws Illegal Argument Exception is placement is invalid
     */
    void placeReinforcements(Player player, Territory territory, int armies, GameState gameState){
        boolean result = canPlaceReinforcements(player, territory, armies, gameState);
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

    /**
     * Determines if placement is valid: must not exceed remaining armies and territory is owned by player
     */
    boolean canPlaceReinforcements(Player player, Territory territory, int armies, GameState gameState){
        // get all territories owned by player
        List<Territory> territories = player.getControlledTerritories();
        int territory_index = territories.indexOf(territory);

        // if the territory is not found (index is -1)
        if (territory_index == -1){
            return false;
        }
        // if the armies we want to place is greater than the remaining armies of the player
        if (player.getRemainingArmiesToPlace() < armies) {
            return false;
        }
        return true;
    }

}
