package service;

import model.*;


import java.util.List;

import net.bytebuddy.pool.TypePool;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ReinforcementServiceTest {

    @Test
    void shouldAllowPlayerToPlaceReinforcementsOnOwnedTerritory() {
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories1 = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 4, controlled_territories1);
        Territory t1 = new Territory("Indonesia", player1, 3, Continent.AUSTRALIA);
        Territory t2 = new Territory("Greenland", player1, 1, Continent.NORTH_AMERICA);
        controlled_territories1.add(t1);
        controlled_territories1.add(t2);
        player1.setControlledTerritories(controlled_territories1);
        int armies_we_will_place = 4;
        assertDoesNotThrow(() -> rs.placeReinforcements(player1, t1, armies_we_will_place, gameState));
    }

    @Test
    void shouldRejectPlacementOnTerritoryNotOwnedByPlayer() {
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories1 = new ArrayList<>();
        List<Territory> controlled_territories2 = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 4, controlled_territories1);
        Player player2 = new Player(2, "B", "Blue", 4, controlled_territories2);
        Territory t1 = new Territory("Indonesia", player1, 3, Continent.AUSTRALIA);
        Territory t2 = new Territory("Greenland", player1, 1, Continent.NORTH_AMERICA);
        Territory t3 = new Territory("Peru", player2, 1, Continent.SOUTH_AMERICA);
        controlled_territories1.add(t1);
        controlled_territories1.add(t2);
        controlled_territories2.add(t3);
        player1.setControlledTerritories(controlled_territories1);
        player2.setControlledTerritories(controlled_territories2);
        int armies_we_will_place = 4;
        assertThrows(IllegalArgumentException.class, () -> {
            rs.placeReinforcements(player1, t3, armies_we_will_place, gameState);
        }, "Your army value or territory is not valid, please try again.");
    }

    @Test
    void shouldRejectPlacementWhenArmiesExceedRemainingReinforcements() {
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories1 = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 4, controlled_territories1);
        Territory t1 = new Territory("Indonesia", player1, 3, Continent.AUSTRALIA);
        Territory t2 = new Territory("Greenland", player1, 1, Continent.NORTH_AMERICA);
        controlled_territories1.add(t1);
        controlled_territories1.add(t2);
        player1.setControlledTerritories(controlled_territories1);
        int armies_we_will_place = 5;
        assertThrows(IllegalArgumentException.class, () -> {
            rs.placeReinforcements(player1, t2, armies_we_will_place, gameState);
        }, "Your army value or territory is not valid, please try again.");
    }

    @Test
    void shouldDecreaseRemainingReinforcementsAfterValidPlacement() {
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories1 = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 4, controlled_territories1);
        Territory t1 = new Territory("Indonesia", player1, 3, Continent.AUSTRALIA);
        Territory t2 = new Territory("Greenland", player1, 1, Continent.NORTH_AMERICA);
        controlled_territories1.add(t1);
        controlled_territories1.add(t2);
        player1.setControlledTerritories(controlled_territories1);
        int armies_we_will_place = 3;
        rs.placeReinforcements(player1, t1, armies_we_will_place, gameState);
        int remaining_army_count_post_place = player1.getRemainingArmiesToPlace();
        assertEquals(1, remaining_army_count_post_place);

    }

    @Test
    void shouldUpdateTerritoryArmyCountAfterValidPlacement() {
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        List<Territory> controlled_territories1 = new ArrayList<>();
        Player player1 = new Player(1, "A", "Red", 4, controlled_territories1);
        Territory t1 = new Territory("Indonesia", player1, 3, Continent.AUSTRALIA);
        Territory t2 = new Territory("Greenland", player1, 1, Continent.NORTH_AMERICA);
        controlled_territories1.add(t1);
        controlled_territories1.add(t2);
        player1.setControlledTerritories(controlled_territories1);
        int armies_we_will_place = 2;
        rs.placeReinforcements(player1, t1, armies_we_will_place, gameState);
        int new_army_count_post_place = t1.getArmyCount();
        assertEquals(5, new_army_count_post_place);
    }

}
