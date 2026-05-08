package service;

import model.GamePhase;
import model.GameState;
import model.Player;

import java.util.List;


public class GameSetupService{

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 6;

    public void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYERS || playerCount > MAX_PLAYERS){
            throw new IllegalArgumentException(
                    "Player count must be between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ", but got: " + playerCount
            );
        }
    }

    public void initializeTurnOrder(GameState gameState){
        List<Player> players_TO = gameState.getPlayers();
        // Collections.shuffle(players_TO);
        gameState.setTurnOrder(players_TO);
    }

    public void startFirstTurn(GameState gameState){
        List<Player> players_TO = gameState.getTurnOrder();
        Player first_pl = players_TO.get(0);
        gameState.setCurrentPlayer(first_pl);
    }
    public GameState createNewGame(List<String> names, List<String> colors){
        // create a new game state
        GameState gameState = new GameState();
        // assign players
        TerritoryAssignmentService TerrService = new TerritoryAssignmentService();
        TerrService.assignTerritories(gameState);


        return gameState;
    }
    public GameState orchestration(List<String> pre_names, List<String> pre_colors){
        GameState gameState = createNewGame(pre_names, pre_colors);
        initializeTurnOrder(gameState);
        startFirstTurn(gameState);
        gameState.setCurrentPhase(GamePhase.REINFORCEMENT);
        return gameState;

    }
    }



