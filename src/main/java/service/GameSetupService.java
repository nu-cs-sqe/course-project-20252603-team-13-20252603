package service;

import model.Player;

import java.util.List;

public class GameSetupService {

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 6;

    public boolean validatePlayerCount(int playerCount) {
        return playerCount >= MIN_PLAYERS && playerCount <= MAX_PLAYERS;
    }

}
