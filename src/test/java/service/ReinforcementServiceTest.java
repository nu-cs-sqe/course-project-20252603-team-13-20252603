package service;

import model.GamePhase;
import model.GameState;
import model.Player;
import model.Continent;
import service.ReinforcementService;
import java.util.ArrayList;
import java.util.List;

import model.Territory;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReinforcementServiceTest {

    @Test
    void shouldReturnMinimumReinforcementWhenPlayerOwnsFewTerritories() {
        // TC1
        ReinforcementService rs = new ReinforcementService();
        List<Territory> controlled_territories = new ArrayList<>();
        GameState gameState1 = new GameState();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        Territory t1 = new Territory("Alaska", player1, 0, Continent.NORTH_AMERICA);
        Territory t2 = new Territory("Indonesia", player1, 0, Continent.AUSTRALIA);
        controlled_territories.add(t1);
        controlled_territories.add(t2);
        gameState1.setTerritories(controlled_territories);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr);
    }

    @Test
    void shouldCalculateBaseReinforcementFromTerritoryCount() {
        // TC1
        ReinforcementService rs = new ReinforcementService();
        // include 9 territories

        List<Territory> controlled_territories = new ArrayList<>();
        GameState gameState1 = new GameState();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        Territory t1 = new Territory("Alaska", player1, 0, Continent.NORTH_AMERICA);
        Territory t2 = new Territory("Alaska", player1, 0, Continent.NORTH_AMERICA);
        Territory t3 = new Territory("Central America", player1, 0, Continent.NORTH_AMERICA);
        Territory t4 = new Territory("Western United States", player1, 0, Continent.NORTH_AMERICA);
        Territory t5 = new Territory("Southern United States", player1, 0, Continent.NORTH_AMERICA);
        Territory t6 = new Territory("Quebec", player1, 0, Continent.NORTH_AMERICA);
        Territory t7 = new Territory("Ontario", player1, 0, Continent.NORTH_AMERICA);
        Territory t8 = new Territory("Greenland", player1, 0, Continent.NORTH_AMERICA);
        Territory t9 = new Territory("Peru", player1, 0, Continent.SOUTH_AMERICA);
        controlled_territories.add(t1);
        controlled_territories.add(t2);
        controlled_territories.add(t3);
        controlled_territories.add(t4);
        controlled_territories.add(t5);
        controlled_territories.add(t5);
        controlled_territories.add(t6);
        controlled_territories.add(t7);
        controlled_territories.add(t8);
        controlled_territories.add(t9);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr);
    }

    @Test
    void shouldCalculateCorrectReinforcementAtBoundaryValues() {
        ReinforcementService rs = new ReinforcementService();

        // TC1: 1 -- > 3 armies
        List<Territory> controlled_territories = new ArrayList<>();
        GameState gameState1 = new GameState();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        Territory t1 = new Territory("Alaska", player1, 0, Continent.NORTH_AMERICA);
        Territory t2 = new Territory("Northwest Territory", player1, 0, Continent.NORTH_AMERICA);
        Territory t3 = new Territory("Central America", player1, 0, Continent.NORTH_AMERICA);
        Territory t4 = new Territory("Western United States", player1, 0, Continent.NORTH_AMERICA);
        Territory t5 = new Territory("Southern United States", player1, 0, Continent.NORTH_AMERICA);
        Territory t6 = new Territory("Quebec", player1, 0, Continent.NORTH_AMERICA);
        Territory t7 = new Territory("Ontario", player1, 0, Continent.NORTH_AMERICA);
        Territory t8 = new Territory("Greenland", player1, 0, Continent.NORTH_AMERICA);
        Territory t9 = new Territory("Peru", player1, 0, Continent.SOUTH_AMERICA);
        Territory t10 = new Territory("Brazil", player1, 0, Continent.SOUTH_AMERICA);
        Territory t11 = new Territory("Argentina", player1, 0, Continent.SOUTH_AMERICA);
        Territory t12 = new Territory("Venezuela", player1, 0, Continent.SOUTH_AMERICA);
        Territory t13 = new Territory("Iceland", player1, 0, Continent.EUROPE);
        Territory t14 = new Territory("Scandinavia", player1, 0, Continent.EUROPE);
        Territory t15 = new Territory("Great Britain", player1, 0, Continent.EUROPE);
        Territory t16 = new Territory("Ukraine", player1, 0, Continent.EUROPE);
        Territory t17 = new Territory("Western Europe", player1, 0, Continent.EUROPE);
        Territory t18 = new Territory("Southern Europe", player1, 0, Continent.EUROPE);
        Territory t19 = new Territory("Eastern Europe", player1, 0, Continent.EUROPE);
        Territory t20 = new Territory("Egypt", player1, 0, Continent.AFRICA);
        Territory t21 = new Territory("Congo", player1, 0, Continent.AFRICA);
        Territory t22 = new Territory("Madagascar", player1, 0, Continent.AFRICA);
        Territory t23 = new Territory("North Africa", player1, 0, Continent.AFRICA);
        Territory t24 = new Territory("East Africa", player1, 0, Continent.AFRICA);
        Territory t25 = new Territory("South Africa", player1, 0, Continent.AFRICA);
        Territory t26 = new Territory("New Guinea", player1, 0, Continent.AUSTRALIA);
        Territory t27 = new Territory("Indonesia", player1, 0, Continent.AUSTRALIA);
        Territory t28 = new Territory("Western Australia", player1, 0, Continent.AUSTRALIA);
        Territory t29 = new Territory("Eastern Australia", player1, 0, Continent.AUSTRALIA);
        Territory t30 = new Territory("Alberta", player1, 0, Continent.NORTH_AMERICA);
        Territory t31 = new Territory("Japan", player1, 0, Continent.ASIA);
        Territory t32 = new Territory("China", player1, 0, Continent.ASIA);
        Territory t33 = new Territory("Ural", player1, 0, Continent.ASIA);
        Territory t34 = new Territory("Siberia", player1, 0, Continent.ASIA);
        Territory t35 = new Territory("Kamchatka", player1, 0, Continent.ASIA);
        Territory t36 = new Territory("Irkutsk", player1, 0, Continent.ASIA);
        Territory t37 = new Territory("Mongolia", player1, 0, Continent.ASIA);
        Territory t38 = new Territory("Afghanistan", player1, 0, Continent.ASIA);
        Territory t39 = new Territory("Siam", player1, 0, Continent.ASIA);
        Territory t40 = new Territory("Middle East", player1, 0, Continent.ASIA);
        Territory t41 = new Territory("India", player1, 0, Continent.ASIA);
        Territory t42 = new Territory("Yakutsk", player1, 0, Continent.ASIA);
        controlled_territories.add(t1);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr);
        // TC2: 9 -- > 3 armies
        controlled_territories.add(t2);
        controlled_territories.add(t3);
        controlled_territories.add(t4);
        controlled_territories.add(t5);
        controlled_territories.add(t6);
        controlled_territories.add(t7);
        controlled_territories.add(t8);
        controlled_territories.add(t9);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr2 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr2);
        // TC3: 11 -- > 3 armies
        controlled_territories.add(t10);
        controlled_territories.add(t11);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr3 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(3, actual_owned_terr3);
        // TC4: 12 -- > 4 armies
        controlled_territories.add(t12);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr4 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(4, actual_owned_terr4);
        // TC5: 14 -- > 4 armies
        controlled_territories.add(t13);
        controlled_territories.add(t14);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr5 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(4, actual_owned_terr5);
        // TC6: 15 -- > 5 armies
        controlled_territories.add(t15);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr6 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(5, actual_owned_terr6);
        // TC7: 17 -- > 5 armies
        controlled_territories.add(t16);
        controlled_territories.add(t17);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr7 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(5, actual_owned_terr7);
        // TC8: 18 -- > 6 armies
        controlled_territories.add(t18);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr8 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(6, actual_owned_terr8);
        // TC9: 20 -- > 6 armies
        controlled_territories.add(t19);
        controlled_territories.add(t20);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr9 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(6, actual_owned_terr9);
        // TC10: 21 -- > 7 armies
        controlled_territories.add(t21);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr10 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(7, actual_owned_terr10);
        // TC11: 23 -- > 7 armies
        controlled_territories.add(t22);
        controlled_territories.add(t23);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr11 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(7, actual_owned_terr11);
        // TC12: 24 -- > 8 armies
        controlled_territories.add(t24);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr12 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(8, actual_owned_terr12);
        // TC13: 26 -- > 8 armies
        controlled_territories.add(t25);
        controlled_territories.add(t26);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr13 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(8, actual_owned_terr13);
        // TC14: 27 -- > 9 armies
        controlled_territories.add(t27);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr14 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(9, actual_owned_terr14);
        // TC15: 29 -- > 9 armies
        controlled_territories.add(t29);
        controlled_territories.add(t30);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr15 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(9, actual_owned_terr15);
        // TC16: 30 -- > 10 armies
        controlled_territories.add(t30);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr16 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(10, actual_owned_terr16);
        // TC17: 32 -- > 10 armies
        controlled_territories.add(t31);
        controlled_territories.add(t32);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr17 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(10, actual_owned_terr17);
        // TC18: 33 -- > 11 armies
        controlled_territories.add(t33);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr18 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(11, actual_owned_terr18);
        // TC19: 35 -- > 11 armies
        controlled_territories.add(t34);
        controlled_territories.add(t35);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr19 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(11, actual_owned_terr19);
        // TC20: 36 -- > 12 armies
        controlled_territories.add(t36);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr20 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(12, actual_owned_terr20);
        // TC21: 38 -- > 12 armies
        controlled_territories.add(t37);
        controlled_territories.add(t38);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr21 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(12, actual_owned_terr21);
        // TC22: 39 -- > 13 armies
        controlled_territories.add(t39);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr22 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(13, actual_owned_terr22);
        // TC23: 41 -- > 13 armies
        controlled_territories.add(t40);
        controlled_territories.add(t41);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr23 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(13, actual_owned_terr23);
        // TC24: 42 -- > 14 armies
        controlled_territories.add(t42);
        player1.setControlledTerritories(controlled_territories);
        int actual_owned_terr24 = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(14, actual_owned_terr24);
    }

}
