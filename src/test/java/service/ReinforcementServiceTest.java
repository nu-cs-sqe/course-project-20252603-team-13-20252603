package service;

import model.Continent;
import model.Player;
import model.Territory;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import model.GameState;
import service.ReinforcementService;

import static org.junit.jupiter.api.Assertions.*;

public class ReinforcementServiceTest {

    @Test
    void shouldReturnZeroBonusWhenPlayerControlsNoFullContinent() {
        // player has 5/6 in AFRICA continent, one in Asia, no bonus
        ReinforcementService rs = new ReinforcementService();

        GameState gameState = new GameState();
        List<Territory> controlled_territories = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        Territory t1 = new Territory("Egypt", player1, 0, Continent.AFRICA);
        Territory t2 = new Territory("Congo", player1, 0, Continent.AFRICA);
        Territory t3 = new Territory("Madagascar", player1, 0, Continent.AFRICA);
        Territory t4 = new Territory("East Africa", player1, 0, Continent.AFRICA);
        Territory t5 = new Territory("South Africa", player1, 0, Continent.AFRICA);
        Territory t6 = new Territory("Japan", player1, 0, Continent.ASIA);
        controlled_territories.add(t1);
        controlled_territories.add(t2);
        controlled_territories.add(t3);
        controlled_territories.add(t4);
        controlled_territories.add(t5);
        controlled_territories.add(t6);
        player1.setControlledTerritories(controlled_territories);
        int actual_bonus = rs.calculateContinentBonus(player1, gameState);
        assertEquals(0, actual_bonus);
    }

    @Test
    void shouldReturnCorrectBonusWhenPlayerControlsOneContinent() {
        // player has control over one full continent plus one in every other continent
        // Africa
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        Territory t1 = new Territory("Egypt", player1, 0, Continent.AFRICA);
        Territory t2 = new Territory("Congo", player1, 0, Continent.AFRICA);
        Territory t3 = new Territory("Madagascar", player1, 0, Continent.AFRICA);
        Territory t4 = new Territory("East Africa", player1, 0, Continent.AFRICA);
        Territory t5 = new Territory("South Africa", player1, 0, Continent.AFRICA);
        Territory t6 = new Territory("Japan", player1, 0, Continent.ASIA);
        controlled_territories.add(t1);
        controlled_territories.add(t2);
        controlled_territories.add(t3);
        controlled_territories.add(t4);
        controlled_territories.add(t5);
        controlled_territories.add(t6);
        player1.setControlledTerritories(controlled_territories);
        int actual_bonus = rs.calculateContinentBonus(player1, gameState);
        assertEquals(0, actual_bonus);

        // Australia

        List<Territory> controlled_territories2 = new ArrayList<>();
        Player player2 = new Player(1, "A", "Red", 0, controlled_territories2);
        Territory t21 = new Territory("Western Australia", player1, 0, Continent.AUSTRALIA);
        Territory t22 = new Territory("Eastern Australia", player1, 0, Continent.AUSTRALIA);
        Territory t23 = new Territory("Indonesia", player1, 0, Continent.AUSTRALIA);
        Territory t24 = new Territory("New Guinea", player1, 0, Continent.AUSTRALIA);
        controlled_territories2.add(t21);
        controlled_territories2.add(t22);
        controlled_territories2.add(t23);
        controlled_territories2.add(t24);
        player2.setControlledTerritories(controlled_territories2);
        int actual_bonus2 = rs.calculateContinentBonus(player2, gameState);
        assertEquals(2, actual_bonus2);

        // South America
        List<Territory> controlled_territories3 = new ArrayList<>();
        Player player3 = new Player(1, "A", "Red", 0, controlled_territories3);
        Territory t31 = new Territory("Peru", player1, 0, Continent.SOUTH_AMERICA);
        Territory t32 = new Territory("Argentina", player1, 0, Continent.SOUTH_AMERICA);
        Territory t33 = new Territory("Venezuela", player1, 0, Continent.SOUTH_AMERICA);
        Territory t34 = new Territory("Brazil", player1, 0, Continent.SOUTH_AMERICA);
        controlled_territories3.add(t31);
        controlled_territories3.add(t32);
        controlled_territories3.add(t33);
        controlled_territories3.add(t34);
        player3.setControlledTerritories(controlled_territories3);
        int actual_bonus3 = rs.calculateContinentBonus(player3, gameState);
        assertEquals(2, actual_bonus3);

        // North America
        List<Territory> controlled_territories4 = new ArrayList<>();
        Player player4 = new Player(1, "A", "Red", 0, controlled_territories4);
        Territory t41 = new Territory("Alaska", player1, 0, Continent.NORTH_AMERICA);
        Territory t42 = new Territory("Northwest Territory", player1, 0, Continent.NORTH_AMERICA);
        Territory t43 = new Territory("Greenland", player1, 0, Continent.NORTH_AMERICA);
        Territory t44 = new Territory("Alberta", player1, 0, Continent.NORTH_AMERICA);
        Territory t45 = new Territory("Ontario", player1, 0, Continent.NORTH_AMERICA);
        Territory t46 = new Territory("Quebec", player1, 0, Continent.NORTH_AMERICA);
        Territory t47 = new Territory("Western United States", player1, 0, Continent.NORTH_AMERICA);
        Territory t48 = new Territory("Eastern United States", player1, 0, Continent.NORTH_AMERICA);
        Territory t49 = new Territory("Central America", player1, 0, Continent.NORTH_AMERICA);
        controlled_territories4.add(t41);
        controlled_territories4.add(t42);
        controlled_territories4.add(t43);
        controlled_territories4.add(t44);
        controlled_territories4.add(t45);
        controlled_territories4.add(t46);
        controlled_territories4.add(t47);
        controlled_territories4.add(t48);
        controlled_territories4.add(t49);
        player4.setControlledTerritories(controlled_territories4);
        int actual_bonus4 = rs.calculateContinentBonus(player4, gameState);
        assertEquals(5, actual_bonus4);

        // Europe
        List<Territory> controlled_territories5 = new ArrayList<>();
        Player player5 = new Player(1, "A", "Red", 0, controlled_territories5);
        Territory t51 = new Territory("Iceland", player1, 0, Continent.EUROPE);
        Territory t52 = new Territory("Great Britain", player1, 0, Continent.EUROPE);
        Territory t53 = new Territory("Western Europe", player1, 0, Continent.EUROPE);
        Territory t54 = new Territory("Eastern Europe", player1, 0, Continent.EUROPE);
        Territory t55 = new Territory("Ukraine", player1, 0, Continent.EUROPE);
        Territory t56 = new Territory("Southern Europe", player1, 0, Continent.EUROPE);
        Territory t57 = new Territory("Scandinavia", player1, 0, Continent.EUROPE);
        controlled_territories5.add(t51);
        controlled_territories5.add(t52);
        controlled_territories5.add(t53);
        controlled_territories5.add(t54);
        controlled_territories5.add(t55);
        controlled_territories5.add(t56);
        controlled_territories5.add(t57);
        player5.setControlledTerritories(controlled_territories5);
        int actual_bonus5 = rs.calculateContinentBonus(player5, gameState);
        assertEquals(5, actual_bonus5);

        // Asia
        List<Territory> controlled_territories6 = new ArrayList<>();
        Player player6 = new Player(1, "A", "Red", 0, controlled_territories6);
        Territory t61 = new Territory("Ural", player1, 0, Continent.ASIA);
        Territory t62 = new Territory("Siberia", player1, 0, Continent.ASIA);
        Territory t63 = new Territory("Yakutsk", player1, 0, Continent.ASIA);
        Territory t64 = new Territory("Kamchatka", player1, 0, Continent.ASIA);
        Territory t65 = new Territory("Irkutsk", player1, 0, Continent.ASIA);
        Territory t66 = new Territory("Afghanistan", player1, 0, Continent.ASIA);
        Territory t67 = new Territory("Mongolia", player1, 0, Continent.ASIA);
        Territory t68 = new Territory("Siam", player1, 0, Continent.ASIA);
        Territory t69 = new Territory("Western Europe", player1, 0, Continent.ASIA);
        Territory t610 = new Territory("Middle East", player1, 0, Continent.ASIA);
        Territory t611 = new Territory("Japan", player1, 0, Continent.ASIA);
        Territory t612 = new Territory("India", player1, 0, Continent.ASIA);
        Territory t613 = new Territory("China", player1, 0, Continent.ASIA);
        controlled_territories6.add(t61);
        controlled_territories6.add(t62);
        controlled_territories6.add(t63);
        controlled_territories6.add(t64);
        controlled_territories6.add(t65);
        controlled_territories6.add(t66);
        controlled_territories6.add(t67);
        controlled_territories6.add(t68);
        controlled_territories6.add(t69);
        controlled_territories6.add(t610);
        controlled_territories6.add(t611);
        controlled_territories6.add(t612);
        player6.setControlledTerritories(controlled_territories6);
        int actual_bonus6 = rs.calculateContinentBonus(player6, gameState);
        assertEquals(7, actual_bonus6);

    }

    @Test
    void shouldReturnCombinedBonusWhenPlayerControlsMultipleContinents() {
        // 1 player created, each controls 2 continents
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        Territory t1 = new Territory("Egypt", player1, 0, Continent.AFRICA);
        Territory t2 = new Territory("Congo", player1, 0, Continent.AFRICA);
        Territory t3 = new Territory("Madagascar", player1, 0, Continent.AFRICA);
        Territory t4 = new Territory("East Africa", player1, 0, Continent.AFRICA);
        Territory t5 = new Territory("South Africa", player1, 0, Continent.AFRICA);
        Territory t6 = new Territory("Japan", player1, 0, Continent.AFRICA);
        Territory t21 = new Territory("Western Australia", player1, 0, Continent.AUSTRALIA);
        Territory t22 = new Territory("Eastern Australia", player1, 0, Continent.AUSTRALIA);
        Territory t23 = new Territory("Indonesia", player1, 0, Continent.AUSTRALIA);
        Territory t24 = new Territory("New Guinea", player1, 0, Continent.AUSTRALIA);
        controlled_territories.add(t1);
        controlled_territories.add(t2);
        controlled_territories.add(t3);
        controlled_territories.add(t4);
        controlled_territories.add(t5);
        controlled_territories.add(t6);
        controlled_territories.add(t21);
        controlled_territories.add(t22);
        controlled_territories.add(t23);
        controlled_territories.add(t24);
        player1.setControlledTerritories(controlled_territories);

        int actual_bonus = rs.calculateContinentBonus(player1, gameState);
        assertEquals(5, actual_bonus);

    }

    @Test
    void shouldNotGrantBonusWhenOneTerritoryInContinentIsOwnedByAnotherPlayer() {
        // one continent, 2 players, all but one go to one player
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories1 = new ArrayList<>();
        List<Territory> controlled_territories2 = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories1);
        Player player2 = new Player(1, "A", "Red", 0, controlled_territories2);
        Territory t21 = new Territory("Western Australia", player1, 0, Continent.AUSTRALIA);
        Territory t22 = new Territory("Eastern Australia", player1, 0, Continent.AUSTRALIA);
        Territory t23 = new Territory("Indonesia", player1, 0, Continent.AUSTRALIA);
        Territory t24 = new Territory("New Guinea", player1, 0, Continent.AUSTRALIA);
        controlled_territories1.add(t21);
        controlled_territories1.add(t22);
        controlled_territories1.add(t23);
        controlled_territories2.add(t24);
        player1.setControlledTerritories(controlled_territories1);
        player2.setControlledTerritories(controlled_territories2);
        int actual_bonus2 = rs.calculateContinentBonus(player1, gameState);
        assertEquals(0, actual_bonus2);
    }

}
