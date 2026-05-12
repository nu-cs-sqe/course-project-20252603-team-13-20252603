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
        Territory t2 = new Territory();
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
        Territory t1 = new Territory();
        List<Territory> controlled_territories = List.of(t1);
        GameState gameState1 = new GameState();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr);
        // 9 -- > 3 armies
        Territory t2 = new Territory();
        Territory t3 = new Territory();
        Territory t4 = new Territory();
        Territory t5 = new Territory();
        Territory t6 = new Territory();
        Territory t7 = new Territory();
        Territory t8 = new Territory();
        Territory t9 = new Territory();
        List<Territory> controlled_territories2 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        Player player2 = new Player(1, "A", "Red", 0, controlled_territories2);
        int actual_owned_terr2 = rs.calculateBaseReinforcements(player2, gameState1);
        assertEquals(3, actual_owned_terr2);
        // 11 -- > 3 armies
        Territory t10 = new Territory();
        Territory t11 = new Territory();
        List<Territory> controlled_territories3 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11);
        Player player3 = new Player(1, "A", "Red", 0, controlled_territories3);
        int actual_owned_terr3 = rs.calculateBaseReinforcements(player3, gameState1);
        assertEquals(3, actual_owned_terr3);
        // 12 -- > 4 armies
        Territory t12 = new Territory();
        List<Territory> controlled_territories4 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12);
        Player player4 = new Player(1, "A", "Red", 0, controlled_territories4);
        int actual_owned_terr4 = rs.calculateBaseReinforcements(player4, gameState1);
        assertEquals(4, actual_owned_terr4);
        // 14 -- > 4 armies
        Territory t13 = new Territory();
        Territory t14 = new Territory();
        List<Territory> controlled_territories5 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14);
        Player player5 = new Player(1, "A", "Red", 0, controlled_territories5);
        int actual_owned_terr5 = rs.calculateBaseReinforcements(player5, gameState1);
        assertEquals(4, actual_owned_terr5);
        // 15 -- > 5 armies
        Territory t15 = new Territory();
        List<Territory> controlled_territories6 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15);
        Player player6 = new Player(1, "A", "Red", 0, controlled_territories6);
        int actual_owned_terr6 = rs.calculateBaseReinforcements(player6, gameState1);
        assertEquals(5, actual_owned_terr6);
        // 17 -- > 5 armies
        Territory t16 = new Territory();
        Territory t17 = new Territory();
        List<Territory> controlled_territories7 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17);
        Player player7 = new Player(1, "A", "Red", 0, controlled_territories7);
        int actual_owned_terr7 = rs.calculateBaseReinforcements(player7, gameState1);
        assertEquals(5, actual_owned_terr7);
        // 18 -- > 6 armies
        Territory t18 = new Territory();
        List<Territory> controlled_territories8 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18);
        Player player8 = new Player(1, "A", "Red", 0, controlled_territories8);
        int actual_owned_terr8 = rs.calculateBaseReinforcements(player8, gameState1);
        assertEquals(6, actual_owned_terr8);
        // 20 -- > 6 armies
        Territory t19 = new Territory();
        Territory t20 = new Territory();
        List<Territory> controlled_territories9 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20);
        Player player9 = new Player(1, "A", "Red", 0, controlled_territories9);
        int actual_owned_terr9 = rs.calculateBaseReinforcements(player9, gameState1);
        assertEquals(6, actual_owned_terr9);
        // 21 -- > 7 armies
        // 23 -- > 7 armies
        // 24 -- > 8 armies
        // 26 -- > 8 armies
        // 27 -- > 9 armies
        // 29 -- > 9 armies
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
