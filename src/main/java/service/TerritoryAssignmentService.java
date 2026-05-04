package service;

import model.Player;
import model.Territory;
import model.GameState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TerritoryAssignmentService {

	private TerritoryAdjacencyService territoryAdjacencyService;

	public TerritoryAssignmentService() {
		this.territoryAdjacencyService = new TerritoryAdjacencyService();
	}

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

	/**
	 * Randomly assign all 42 territories to players in game state.
	 * Each territory gets 1 army and is assigned to a player.
	 * Territories are distributed as evenly as possible among players.
	 */
	// TODO: This method will be changed to assign territories based on player preferences in the future. For now, it just does a random assignment.
	public void assignTerritories(GameState gameState) {
		Objects.requireNonNull(gameState, "gameState cannot be null");
		List<Player> players = gameState.getPlayers();
		if (players == null || players.isEmpty()) {
			throw new IllegalArgumentException("gameState must have at least one player");
		}

		// Create all 42 territories
		List<Territory> allTerritories = territoryAdjacencyService.createAllTerritories();

		// Assign territories to players in round-robin fashion
		int playerCount = players.size();
		for (int i = 0; i < allTerritories.size(); i++) {
			Territory territory = allTerritories.get(i);
			Player assignedPlayer = players.get(i % playerCount);
			
			// Set territory owner and place 1 army
			territory.setOwner(assignedPlayer);
			territory.setArmyCount(1);
			
			// Add territory to player's controlled territories
			assignedPlayer.addControlledTerritory(territory);
		}

		// Update game state with territories
		gameState.setTerritories(allTerritories);
	}
}
