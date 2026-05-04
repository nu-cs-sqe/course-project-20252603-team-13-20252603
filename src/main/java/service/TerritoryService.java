package service;

import java.util.List;

import model.GameState;
import model.Player;
import model.Territory;

public final class TerritoryService {

    private TerritoryService() {
    }

    public static Territory findTerritoryByName(GameState state, String name) {
        if (state == null) {
            throw new IllegalArgumentException("state cannot be null");
        }
        List<Territory> territories = state.getTerritories();
        if (territories == null) {
            throw new IllegalArgumentException("territories cannot be null");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        for (Territory territory : territories) {
            if (territory != null && territory.getName().equals(name)) {
                return territory;
            }
        }
        throw new IllegalArgumentException("territory not found: " + name);
    }

    public static boolean playerOwnsTerritory(Player player, GameState state, String territoryName) {
        if (player == null || state == null || territoryName == null || territoryName.trim().isEmpty()) {
            return false;
        }
        Territory territory = findTerritoryByName(state, territoryName);
        if (territory.getOwner() == null) {
            return false;
        }
        return territory.getOwner().getId() == player.getId();
    }
}
