package service;

import java.util.ArrayList;
import java.util.List;
import model.Player;
import model.Territory;
import model.GameState;
import model.GamePhase;


public class GameSetupService{


    // void initializeTurnOrder(GameState gameState)
    public void initializeTurnOrder(GameState gameState){
        List<Player> players_TO = gameState.getPlayers();
        // Collections.shuffle(players_TO);
        gameState.setTurnOrder(players_TO);
    }

    // void startFirstTurn(GameState gameState)
    public void startFirstTurn(GameState gameState){
        List<Player> players_TO = gameState.getTurnOrder();
        Player first_pl = players_TO.get(0);
        gameState.setCurrentPlayer(first_pl);
    }

    // GameState createNewGame(List<String> names, List<PlayerColor> colors)

    public GameState createNewGame(List<String> names, List<String> colors){
        // create a new game state
        GameState gameState = new GameState();
        // set the phase to setup
        // call player generation
        // call territory generation
        // call territory distribution

        return gameState;
    }


    // orchestration method that calls the setup steps in order
    public GameState orchestration(List<String> pre_names, List<String> pre_colors){
        GameState gameState = createNewGame(pre_names, pre_colors);
        initializeTurnOrder(gameState);
        startFirstTurn(gameState);
        gameState.setCurrentPhase(GamePhase.REINFORCEMENT);
        return gameState;

    }


}
