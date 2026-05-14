package service;

import model.Player;

import java.util.List;

public class GameSetupService {

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 6;

    public void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYERS || playerCount > MAX_PLAYERS){
            throw new IllegalArgumentException(
                    "Player count must be between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ", but got: " + playerCount
            );
        }
    }

}
