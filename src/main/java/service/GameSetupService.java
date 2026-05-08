package service;

import model.Player;

import java.util.List;

public class PlayerSetupService {

    public List<Player> createPlayers(List<String> names, List<PlayerColor> colors) {
        return null;
    }

    public void validateUniqueColors(List<PlayerColor> colors) {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 6;

    public boolean validatePlayerCount(int playerCount) {
        return playerCount >= MIN_PLAYERS && playerCount <= MAX_PLAYERS;
    }

}
