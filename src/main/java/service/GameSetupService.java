package service;

import model.Player;

import java.util.List;

public class GameSetupService {

    public boolean validatePlayerCount(int playerCount) {
        return playerCount >= 2;
    }

}
