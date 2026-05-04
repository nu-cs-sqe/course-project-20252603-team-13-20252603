package service;

import model.Player;
import model.Territory;
import model.GameState;

import java.util.Objects;

public class TerritoryAssignmentService {

	public void assignTerritoryToPlayer(Territory territory, Player player) {
		if (territory == null) {
			throw new IllegalArgumentException("territory cannot be null");
		}
		if (player == null) {
			throw new IllegalArgumentException("player cannot be null");
		}

		territory.setOwner(player);
	}

	/**
	 * Assign armies to a named territory in the given game state.
	 */
	public static void assignArmyToTerritory(GameState state, Player player, String territoryName, int armyCount) {
		Objects.requireNonNull(state, "state cannot be null");
		Objects.requireNonNull(player, "player cannot be null");

		if (player.getRemainingArmiesToPlace() < armyCount) {
			throw new IllegalArgumentException("Player does not have enough armies to place");
		}

		if (!TerritoryService.playerOwnsTerritory(player, state, territoryName)) {
			throw new IllegalArgumentException("Player does not own the specified territory");
		}

		model.Territory territory = TerritoryService.findTerritoryByName(state, territoryName);
		territory.setArmyCount(territory.getArmyCount() + armyCount);
		player.setRemainingArmiesToPlace(player.getRemainingArmiesToPlace() - armyCount);
	}
}
