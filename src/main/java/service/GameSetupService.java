package service;

import model.Player;

import java.util.List;

public class PlayerSetupService {

    public List<Player> createPlayers(List<String> names, List<PlayerColor> colors) {
        return null;
    }

    public void validateUniqueColors(List<PlayerColor> colors) {
    public boolean validatePlayerCount(int playerCount) {
        return playerCount >= 2 && playerCount <= 6;
    }

}
