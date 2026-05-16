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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @ParameterizedTest
    @CsvSource({"1,3",
            "9,3",
            "11,3",
            "12,4",
            "14,4",
            "15,5",
            "17,5",
            "18,6",
            "20,6",
            "21,7",
            "23,7",
            "24,8",
            "26,8",
            "27,9",
            "29,9",
            "30,10",
            "32,10",
            "33,11",
            "35,11",
            "36,12",
            "38,12",
            "39,13",
            "41,13",
            "42,14"})
    void shouldCalculateCorrectReinforcementAtBoundaryValues(int len, int expected) {
        ReinforcementService rs = new ReinforcementService();

        // TC1: 1 -- > 3 armies
        List<Territory> controlled_territories = new ArrayList<>();
        GameState gameState1 = new GameState();
        for (int i = 0; i < 42; i++) {
            Territory terr = new Territory();
            controlled_territories.add(terr);
        }
        List<Territory> first_group = controlled_territories.subList(0, len);
        Player player1 = new Player(1, "A", "Red", 0, first_group);
        int actual_owned_terr = rs.calculateBaseReinforcements(player1, gameState1);
        assertEquals(expected, actual_owned_terr);

    }

}
