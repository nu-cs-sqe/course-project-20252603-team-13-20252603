package service;

import model.GameState;
import model.Player;
import model.Territory;

public class AssignArmytoTerritoryService {

    private AssignArmytoTerritoryService() {
        // Basic constructor
    }

    public static void assignArmyToTerritory(GameState state, Player player, String territoryName, int armyCount) {
        if (state == null) {
            throw new IllegalArgumentException("state cannot be null");
        }
        if (player == null) {
            throw new IllegalArgumentException("player cannot be null");
        }

        // Check if the player has enough armies to place
        if (player.getRemainingArmiesToPlace() < armyCount) {
            throw new IllegalArgumentException("Player does not have enough armies to place");
        }
        // Check if the territory exists and is owned by the player
        if (!TerritoryService.playerOwnsTerritory(player, state, territoryName)) {
            throw new IllegalArgumentException("Player does not own the specified territory");
        }

        // If all checks pass, assign the armies to the territory and decrement player's remaining armies
        Territory territory = TerritoryService.findTerritoryByName(state, territoryName);
        territory.setArmyCount(territory.getArmyCount() + armyCount);
        player.setRemainingArmiesToPlace(player.getRemainingArmiesToPlace() - armyCount);
    }
}