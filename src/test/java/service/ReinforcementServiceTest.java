package service;

import model.*;


import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReinforcementServiceTest {

    @Test
    void shouldAllowPlayerToPlaceReinforcementsOnOwnedTerritory() {
        ReinforcementService rs = new ReinforcementService();
        GameState gameState = new GameState();
        Territory t1 = new Territory();
        Territory t2 = new Territory();
        List<Territory> controlled_territories1 = List.of(t1, t2);
        Player player1 = new Player(1, "A", "Red", 4, controlled_territories1);
        t1.setOwner(player1);
        t1.setOwner(player1);
        t1.setArmyCount(3);
        t2.setArmyCount(1);
        t1.setContinent(Continent.AUSTRALIA);
        t2.setContinent(Continent.NORTH_AMERICA);
        t1.setName("Indonesia");
        t2.setName("Greenland");
        int armies_we_will_place = 4;
        rs.placeReinforcements(player1, t1, armies_we_will_place, gameState);
        int new_army_count_post_place = t1.getArmyCount();
        assertEquals(7, new_army_count_post_place);
    }

    @Test
    void shouldRejectPlacementOnTerritoryNotOwnedByPlayer() {

    }

    @Test
    void shouldRejectPlacementWhenArmiesExceedRemainingReinforcements() {
        
    }

    @Test
    void shouldDecreaseRemainingReinforcementsAfterValidPlacement() {

    }

    @Test
    void shouldUpdateTerritoryArmyCountAfterValidPlacement() {

    }

}
