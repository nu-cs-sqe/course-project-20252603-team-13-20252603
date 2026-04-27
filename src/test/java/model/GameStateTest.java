package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

public class GameStateTest {

	@Test
	void constructor_initializesCollectionsAsEmptyLists() {
		GameState gameState = new GameState();

		assertNotNull(gameState.getPlayers());
		assertNotNull(gameState.getTerritories());
		assertNotNull(gameState.getTurnOrder());
		assertTrue(gameState.getPlayers().isEmpty());
		assertTrue(gameState.getTerritories().isEmpty());
		assertTrue(gameState.getTurnOrder().isEmpty());
	}

	@Test
	void settersAndGetters_updateAllFields() {
		GameState gameState = new GameState();

		Player currentPlayer = EasyMock.createMock(Player.class);
		List<Player> players = EasyMock.createMock(List.class);
		List<Territory> territories = EasyMock.createMock(List.class);
		List<Player> turnOrder = EasyMock.createMock(List.class);

		EasyMock.expect(players.size()).andStubReturn(2);
		EasyMock.expect(territories.size()).andStubReturn(1);
		EasyMock.expect(turnOrder.size()).andStubReturn(2);

		EasyMock.replay(currentPlayer, players, territories, turnOrder);

		gameState.setPlayers(players);
		gameState.setTerritories(territories);
		gameState.setTurnOrder(turnOrder);
		gameState.setCurrentPlayer(currentPlayer);
		gameState.setCurrentPhase(GamePhase.ATTACK);

		assertEquals(2, gameState.getPlayers().size());
		assertEquals(1, gameState.getTerritories().size());
		assertEquals(2, gameState.getTurnOrder().size());
		assertSame(players, gameState.getPlayers());
		assertSame(territories, gameState.getTerritories());
		assertSame(turnOrder, gameState.getTurnOrder());
		assertSame(currentPlayer, gameState.getCurrentPlayer());
		assertEquals(GamePhase.ATTACK, gameState.getCurrentPhase());

		EasyMock.verify(currentPlayer, players, territories, turnOrder);
	}
}
