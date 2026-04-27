package model;

import java.util.ArrayList;
import java.util.List;

public class GameState {

	private List<Player> players;
	private List<Territory> territories;
	private List<Player> turnOrder;
	private Player currentPlayer;
	private GamePhase currentPhase;

	public GameState() {
		this.players = new ArrayList<>();
		this.territories = new ArrayList<>();
		this.turnOrder = new ArrayList<>();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Territory> getTerritories() {
		return territories;
	}

	public void setTerritories(List<Territory> territories) {
		this.territories = territories;
	}

	public List<Player> getTurnOrder() {
		return turnOrder;
	}

	public void setTurnOrder(List<Player> turnOrder) {
		this.turnOrder = turnOrder;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public GamePhase getCurrentPhase() {
		return currentPhase;
	}

	public void setCurrentPhase(GamePhase currentPhase) {
		this.currentPhase = currentPhase;
	}
}
