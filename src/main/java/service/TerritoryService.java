package service;

import java.util.List;

import model.GameState;
import model.Player;
import model.Territory;

public final class TerritoryService {

    private TerritoryService() {
    }

    public static Territory findTerritoryByName(GameState state, String name) {

        List<Territory> territories = state.getTerritories();

        for (Territory territory : territories) {
            if (territory.getName().equals(name)) {
                return territory;
            }
        }
        throw new IllegalArgumentException("territory not found: " + name);
    }

    public static boolean playerOwnsTerritory(Player player, GameState state, String territoryName) {

        Territory territory = findTerritoryByName(state, territoryName);
        if (territory.getOwner() == null) {
            return false;
        }
        return territory.getOwner().getId() == player.getId();
    }

    public static void conquerTerritory(Player attacker, Territory from, Territory to, int armiesToMove, GameState gameState) {
        // Validate input
        if (armiesToMove <= 0) {
            throw new IllegalArgumentException("armiesToMove must be greater than 0");
        }

        if (from.getArmyCount() < armiesToMove + 1) {
            throw new IllegalArgumentException("attacking territory must keep at least 1 army behind");
        }

        if (from.getOwner().getId() != attacker.getId()) {
            throw new IllegalArgumentException("attacker does not own the attacking territory");
        }

        // Transfer ownership to the attacker
        Player defender = to.getOwner();
        to.setOwner(attacker);

        // Move armies from attacking territory to conquered territory
        from.setArmyCount(from.getArmyCount() - armiesToMove);
        to.setArmyCount(armiesToMove);

        // Update controlled territories
        attacker.addControlledTerritory(to);
        
        // If defender is null, the territory was unoccupied, so we don't need to remove it from the defender's controlled territories
        if (defender != null) {
            defender.getControlledTerritories().remove(to);
        }
    }
}
