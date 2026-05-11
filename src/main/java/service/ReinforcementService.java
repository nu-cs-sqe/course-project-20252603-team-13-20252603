package service;

import model.Player;
import model.GameState;
import model.Territory;

public class ReinforcementService {


    void placeReinforcements(Player player, Territory territory, int armies, GameState gameState){
        boolean result = canPlaceReinforcements(player, territory, armies, gameState);
        if (result) {
            
        }
        else {
            throw new IllegalArgumentException("Your army value or territory is not valid, please try again.");
        }

    }
    //Optional helpers:
    boolean canPlaceReinforcements(Player player, Territory territory, int armies, GameState gameState){

        if (player != territory.getOwner()){
            return false;
        }
        if (player.getRemainingArmiesToPlace() < armies) {
            return false;
        }
        return true;
    }

}
