package service;

import model.Continent;
import model.Player;
import model.Territory;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import java.util.List;
import model.GameState;
import service.ReinforcementService;

import static org.junit.jupiter.api.Assertions.*;

public class ReinforcementServiceTest {

    @Test
    void shouldReturnZeroBonusWhenPlayerControlsNoFullContinent() {
        // player has 5/6 in AFRICA continent, one in Asia, no bonus
        ReinforcementService rs = new ReinforcementService();
        Territory t1 = new Territory();
        Territory t2 = new Territory();
        Territory t3 = new Territory();
        Territory t4 = new Territory();
        Territory t5 = new Territory();
        Territory t6 = new Territory();
        GameState gameState = new GameState();
        List<Territory> controlled_territories = List.of(t1, t2, t3, t4, t5, t6);
        Player player1 = new Player(1, "A", "Red", 0, controlled_territories);
        t1.setOwner(player1);
        t2.setOwner(player1);
        t3.setOwner(player1);
        t4.setOwner(player1);
        t5.setOwner(player1);
        t6.setOwner(player1);
        t2.setArmyCount(3);
        t3.setArmyCount(3);
        t4.setArmyCount(3);
        t5.setArmyCount(3);
        t6.setArmyCount(3);
        t1.setContinent(Continent.AFRICA);
        t2.setContinent(Continent.AFRICA);
        t3.setContinent(Continent.AFRICA);
        t4.setContinent(Continent.AFRICA);
        t5.setContinent(Continent.AFRICA);
        t6.setContinent(Continent.ASIA);
        t1.setName("Egypt");
        t2.setName("Congo");
        t3.setName("Madagascar");
        t4.setName("East Africa");
        t5.setName("South Africa");
        t6.setName("Japan");
        int actual_bonus = rs.calculateContinentBonus(player1, gameState);
        assertEquals(0, actual_bonus);
    }

    @Test
    void shouldReturnCorrectBonusWhenPlayerControlsOneContinent() {
        // player has control over one full continent plus one in every other continent
    }

    @Test
    void shouldReturnCombinedBonusWhenPlayerControlsMultipleContinents() {
        // 3 players created, each controls 2 continents
    }

    @Test
    void shouldNotGrantBonusWhenOneTerritoryInContinentIsOwnedByAnotherPlayer() {
        // one continent, 2 players, all but one go to one player
    }

}
