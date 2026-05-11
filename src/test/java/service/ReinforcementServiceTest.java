package service;

import model.GamePhase;
import model.GameState;
import model.Player;
import model.Continent;
import service.ReinforcementService;

import java.util.List;

import model.Territory;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReinforcementServiceTest {

    @Test
    void shouldReturnMinimumReinforcementWhenPlayerOwnsFewTerritories() {
        ReinforcementService rs = new ReinforcementService();
        List<Territory> empty = List.of();
        Player fake_player = new Player(0, "fake", "fake", 0, empty);
        Territory t1 = new Territory();
                //("Alaska", fake_player, 2, Continent.NORTH_AMERICA);
        Territory t2 = new Territory();
        //("Greenland", fake_player, 2, Continent.NORTH_AMERICA);
        List<Territory> controlled_territories = List.of(t1, t2);
        GameState gameState1 = new GameState();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        gameState1.setTerritories(controlled_territories);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr);
    }

    @Test
    void shouldCalculateBaseReinforcementFromTerritoryCount() {

    }

    @Test
    void shouldCalculateCorrectReinforcementAtBoundaryValues() {

    }

}
