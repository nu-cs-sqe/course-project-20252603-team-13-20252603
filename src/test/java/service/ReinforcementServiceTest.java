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
        Territory t21 = new Territory();
        List<Territory> controlled_territories10 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21);
        Player player10 = new Player(1, "A", "Red", 0, controlled_territories10);
        int actual_owned_terr10 = rs.calculateBaseReinforcements(player10, gameState1);
        assertEquals(7, actual_owned_terr10);
        // 23 -- > 7 armies
        Territory t22 = new Territory();
        Territory t23 = new Territory();
        List<Territory> controlled_territories11 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23);
        Player player11 = new Player(1, "A", "Red", 0, controlled_territories11);
        int actual_owned_terr11 = rs.calculateBaseReinforcements(player11, gameState1);
        assertEquals(7, actual_owned_terr11);
        // 24 -- > 8 armies
        Territory t24 = new Territory();
        List<Territory> controlled_territories12 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24);
        Player player12 = new Player(1, "A", "Red", 0, controlled_territories12);
        int actual_owned_terr12 = rs.calculateBaseReinforcements(player12, gameState1);
        assertEquals(8, actual_owned_terr12);
        // 26 -- > 8 armies
        Territory t25 = new Territory();
        Territory t26 = new Territory();
        List<Territory> controlled_territories13 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26);
        Player player13 = new Player(1, "A", "Red", 0, controlled_territories13);
        int actual_owned_terr13 = rs.calculateBaseReinforcements(player13, gameState1);
        assertEquals(8, actual_owned_terr13);
        // 27 -- > 9 armies
        Territory t27 = new Territory();
        List<Territory> controlled_territories14 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27);
        Player player14 = new Player(1, "A", "Red", 0, controlled_territories14);
        int actual_owned_terr14 = rs.calculateBaseReinforcements(player14, gameState1);
        assertEquals(9, actual_owned_terr14);
        // 29 -- > 9 armies
        Territory t28 = new Territory();
        Territory t29 = new Territory();
        List<Territory> controlled_territories15 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29);
        Player player15 = new Player(1, "A", "Red", 0, controlled_territories15);
        int actual_owned_terr15 = rs.calculateBaseReinforcements(player15, gameState1);
        assertEquals(9, actual_owned_terr15);
        // 30 -- > 10 armies
        Territory t30 = new Territory();
        List<Territory> controlled_territories16 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30);
        Player player16 = new Player(1, "A", "Red", 0, controlled_territories16);
        int actual_owned_terr16 = rs.calculateBaseReinforcements(player16, gameState1);
        assertEquals(10, actual_owned_terr16);
        // 32 -- > 10 armies
        Territory t31 = new Territory();
        Territory t32 = new Territory();
        List<Territory> controlled_territories17 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32);
        Player player17 = new Player(1, "A", "Red", 0, controlled_territories17);
        int actual_owned_terr17 = rs.calculateBaseReinforcements(player17, gameState1);
        assertEquals(10, actual_owned_terr17);
        // 33 -- > 11 armies
        Territory t33 = new Territory();
        List<Territory> controlled_territories18 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33);
        Player player18 = new Player(1, "A", "Red", 0, controlled_territories18);
        int actual_owned_terr18 = rs.calculateBaseReinforcements(player18, gameState1);
        assertEquals(11, actual_owned_terr18);
        // 35 -- > 11 armies
        Territory t34 = new Territory();
        Territory t35 = new Territory();
        List<Territory> controlled_territories19 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35);
        Player player19 = new Player(1, "A", "Red", 0, controlled_territories19);
        int actual_owned_terr19 = rs.calculateBaseReinforcements(player19, gameState1);
        assertEquals(11, actual_owned_terr19);
        // 36 -- > 12 armies
        Territory t36 = new Territory();
        List<Territory> controlled_territories20 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36);
        Player player20 = new Player(1, "A", "Red", 0, controlled_territories20);
        int actual_owned_terr20 = rs.calculateBaseReinforcements(player20, gameState1);
        assertEquals(12, actual_owned_terr20);
        // 38 -- > 12 armies
        Territory t37 = new Territory();
        Territory t38 = new Territory();
        List<Territory> controlled_territories21 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38);
        Player player21 = new Player(1, "A", "Red", 0, controlled_territories21);
        int actual_owned_terr21 = rs.calculateBaseReinforcements(player21, gameState1);
        assertEquals(12, actual_owned_terr21);
        // 39 -- > 13 armies
        Territory t39 = new Territory();
        List<Territory> controlled_territories22 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39);
        Player player22 = new Player(1, "A", "Red", 0, controlled_territories22);
        int actual_owned_terr22 = rs.calculateBaseReinforcements(player22, gameState1);
        assertEquals(13, actual_owned_terr22);
        // 41 -- > 13 armies
        Territory t40 = new Territory();
        Territory t41 = new Territory();
        List<Territory> controlled_territories23 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41);
        Player player23 = new Player(1, "A", "Red", 0, controlled_territories23);
        int actual_owned_terr23 = rs.calculateBaseReinforcements(player23, gameState1);
        assertEquals(13, actual_owned_terr23);
        // 42 -- > 14 armies
        Territory t42 = new Territory();
        List<Territory> controlled_territories24 = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21,
                t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41, t42);
        Player player24 = new Player(1, "A", "Red", 0, controlled_territories24);
        int actual_owned_terr24 = rs.calculateBaseReinforcements(player24, gameState1);
        assertEquals(14, actual_owned_terr24);
    }

}
