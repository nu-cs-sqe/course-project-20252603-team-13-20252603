package service;

import model.Player;
import model.GameState;
import model.Territory;

import java.util.List;

public class ReinforcementService {


    void placeReinforcements(Player player, Territory territory, int armies, GameState gameState){
        boolean result = canPlaceReinforcements(player, territory, armies, gameState);
        if (result) {
            List<Player> players = gameState.getPlayers();
            int player_index = players.indexOf(player);
            Player pl_found = gameState.getPlayers().get(player_index);
            List<Territory> territories = gameState.getTerritories();
            int territory_index = territories.indexOf(territory);
            Territory tr_found = gameState.getTerritories().get(territory_index);

            int current_armies_unplaced = pl_found.getRemainingArmiesToPlace();
            int new_remaining_armies = current_armies_unplaced - armies;
            int current_territories_placed = tr_found.getArmyCount();
            int new_territory_army = armies + current_territories_placed;
            tr_found.setArmyCount(new_territory_army);
            pl_found.setRemainingArmiesToPlace(new_remaining_armies);
        }
        else {
            throw new IllegalArgumentException("Your army value or territory is not valid, please try again.");
        }

    }
    //Optional helpers:
    boolean canPlaceReinforcements(Player player, Territory territory, int armies, GameState gameState){
        List<Player> players = gameState.getPlayers();
        int player_index = players.indexOf(player);
        Player pl_found = gameState.getPlayers().get(player_index);
        List<Territory> territories = gameState.getTerritories();
        int territory_index = territories.indexOf(territory);
        Territory tr_found = gameState.getTerritories().get(territory_index);

        if (pl_found != tr_found.getOwner()){
            return false;
        }
        if (pl_found.getRemainingArmiesToPlace() < armies) {
            return false;
        }
        return true;
    }

}
