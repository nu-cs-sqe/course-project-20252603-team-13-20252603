package service;


import model.GameState;
import model.Player;
import model.Territory;

import java.util.List;

public class ReinforcementService {


    int calculateBaseReinforcements(Player player, GameState gameState) {
        int owner_territories = player.getControlledTerritoryCount();
        int base_reinforcements = Math.max(3, owner_territories / 3);
        return base_reinforcements;
    }
    //Optional helper:


}
