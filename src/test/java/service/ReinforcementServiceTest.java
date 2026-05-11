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
        ReinforcementService rs = new ReinforcementService();
        // include 9 territories
        Territory t1 = new Territory();
        Territory t2 = new Territory();
        Territory t3 = new Territory();
        Territory t4 = new Territory();
        Territory t5 = new Territory();
        Territory t6 = new Territory();
        Territory t7 = new Territory();
        Territory t8 = new Territory();
        Territory t9 = new Territory();
        List<Territory> controlled_territories = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        GameState gameState1 = new GameState();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        gameState1.setTerritories(controlled_territories);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr);
    }

    @Test
    void shouldCalculateCorrectReinforcementAtBoundaryValues() {
        ReinforcementService rs = new ReinforcementService();

        // 1 -- > 3 armies
        // 9 -- > 3 armies
        // 11 -- > 3 armies
        // 12 -- > 4 armies
        // 14 -- > 4 armies
        // 15 -- > 5 armies
        // 17 -- > 5 armies
        // 18 -- > 6 armies
        // 20 -- > 6 armies
        // 21 -- > 7 armies
        // 23 -- > 7 armies
        // 24 -- > 8 armies
        // 26 -- > 8 armies
        // 27 -- > 9 armies
        // 229 -- > 9 armies
        // 30 -- > 10 armies
        // 32 -- > 10 armies
        // 33 -- > 11 armies
        // 35 -- > 11 armies
        // 36 -- > 12 armies
        // 38 -- > 12 armies
        // 39 -- > 13 armies
        // 41 -- > 13 armies
        // 42 -- > 14 armies
    }

}
