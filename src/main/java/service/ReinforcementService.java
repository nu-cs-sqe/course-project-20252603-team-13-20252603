package service;


import model.GameState;
import model.Player;
import model.Territory;

import java.util.List;

public class ReinforcementService {

    /**
     * calculates reinforcements a player received based on current territories owned
     */
    int calculateBaseReinforcements(Player player, GameState gameState) {
        // get controlled territories
        int owner_territories = player.getControlledTerritoryCount();
        // take the territories divide by 3, minimally, we should get three troops
        int base_reinforcements = Math.max(3, owner_territories / 3);
        return base_reinforcements;
    }


}
