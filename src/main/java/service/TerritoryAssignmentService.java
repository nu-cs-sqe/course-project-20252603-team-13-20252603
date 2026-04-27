package service;

import model.Player;
import model.Territory;

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
}
