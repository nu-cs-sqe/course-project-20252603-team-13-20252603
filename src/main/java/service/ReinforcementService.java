package service;


import model.GameState;
import model.Player;
import model.Territory;

import java.util.List;

public class ReinforcementService {


    int calculateBaseReinforcements(Player player, GameState gameState) {
        int owner_territories = countTerritoriesOwnedBy(player, gameState);
        int base_reinforcements = Math.max(3, owner_territories / 3);
        return base_reinforcements;
    }
    //Optional helper:
    int countTerritoriesOwnedBy(Player player, GameState gameState) {
        List<Territory> territories = gameState.getTerritories();
        int count = 0;
        for (int i = 0; i < territories.size(); i++){
            Territory current = territories.get(i);
            Player curr_player = current.getOwner();
            if (curr_player == player) {
                count++;
            }
        }
        return count;
    }

}
