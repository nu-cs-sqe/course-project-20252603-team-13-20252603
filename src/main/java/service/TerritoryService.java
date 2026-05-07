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
}
