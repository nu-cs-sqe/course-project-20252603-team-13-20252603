package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameController{
    private GameState gameState;
    private ArrayList<Integer> territory_distro;

    public GameController() {
    }
    // void initializeTurnOrder(GameState gameState)
    public void initializeTurnOrder(GameState gameState){
        List<Player> players_TO = gameState.getPlayers();
        Collections.shuffle(players_TO);
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
        GameState gameState = new GameState();
        gameState.setCurrentPhase(GamePhase.SETUP);

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Territory> territories = new ArrayList<>();
        int num_players = names.size();

        ArrayList<Player> new_players = player_creation(players, num_players, names, colors);
        Collections.shuffle(new_players);
        // Do later not necessary now
        //gameState.setPlayers(new_players);
        setTerritory_distro(num_players);

        ArrayList<Territory> init_territories = makeTerritories_init();
        Collections.shuffle(init_territories);


        ArrayList<Territory> new_territories = distributeTerritories(init_territories, new_players, num_players);


        ArrayList<Player> updated_players = insert_Remaining_armies(new_players);

        gameState.setPlayers(updated_players);
        gameState.setTerritories(new_territories);


        return gameState;
    }

    private ArrayList<Player> insert_Remaining_armies(ArrayList<Player> players) {
        int length = players.size();
        int total_armies = army_distributor(length);
        for (int i = 0; i < length; i++) {
            int current_terr_count = territory_distro.get(i);
            int remaining_armies = total_armies - current_terr_count;
            Player current_player = players.get(i);
            current_player.setRemainingArmiesToPlace(remaining_armies);
        }
        return players;
    }

    private ArrayList<Territory> makeTerritories_init() {

        ArrayList<Territory> terras = new ArrayList<>();
        Player placeholder = new Player(0, "Temp_player", "Black", 0);

        terras.add(new Territory("Alaska", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Northwest Territory", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Greenland", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Alberta", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Ontario", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Quebec", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Western United States", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Eastern United States", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Central America", placeholder, 0, Continent.NORTH_AMERICA));
        terras.add(new Territory("Venezuela", placeholder, 0, Continent.SOUTH_AMERICA));
        terras.add(new Territory("Peru", placeholder, 0, Continent.SOUTH_AMERICA));
        terras.add(new Territory("Brazil", placeholder, 0, Continent.SOUTH_AMERICA));
        terras.add(new Territory("Argentina", placeholder, 0, Continent.SOUTH_AMERICA));
        terras.add(new Territory("Iceland", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("Scandinavia", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("Great Britain", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("Northern Europe", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("Western Europe", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("Ukraine", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("Southern Europe", placeholder, 0, Continent.EUROPE));
        terras.add(new Territory("North Africa", placeholder, 0, Continent.AFRICA));
        terras.add(new Territory("Egypt", placeholder, 0, Continent.AFRICA));
        terras.add(new Territory("East Africa", placeholder, 0, Continent.AFRICA));
        terras.add(new Territory("Congo", placeholder, 0, Continent.AFRICA));
        terras.add(new Territory("South Africa", placeholder, 0, Continent.AFRICA));
        terras.add(new Territory("Madagascar", placeholder, 0, Continent.AFRICA));
        terras.add(new Territory("Ural", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Siberia", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Yakutsk", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Kamchatka", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Irkutsk", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Mongolia", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Japan", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Afghanistan", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("China", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Middle East", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("India", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Siam", placeholder, 0, Continent.ASIA));
        terras.add(new Territory("Indonesia", placeholder, 0, Continent.AUSTRALIA));
        terras.add(new Territory("New Guinea", placeholder, 0, Continent.AUSTRALIA));
        terras.add(new Territory("Western Australia", placeholder, 0, Continent.AUSTRALIA));
        terras.add(new Territory("Eastern Australia", placeholder, 0, Continent.AUSTRALIA));

        return terras;
    }



    private ArrayList<Territory> distributeTerritories(ArrayList<Territory> territories, ArrayList<Player> players, int num_player) {
        int start = 0;
        for (int i = 0; i < num_player; i++) {
            Player current_player = players.get(i);
            int current_terr_count = territory_distro.get(i);
            int end = current_terr_count + start;
            for (int j = start; j < end; j++) {
                Territory curr_territory = territories.get(j);
                curr_territory.setOwner(current_player);
                curr_territory.setArmyCount(1);
            }
            start = end;



        }
        return territories;
    }

    private void setTerritory_distro(int num_players){
        if (num_players == 4) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(10);
            arr.add(11);
            arr.add(10);
            arr.add(11);
            Collections.shuffle(arr);
            territory_distro = arr;
        }
        else if (num_players == 3) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(14);
            arr.add(14);
            arr.add(14);
            territory_distro = arr;
        }
        else if (num_players == 6) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(7);
            arr.add(7);
            arr.add(7);
            arr.add(7);
            arr.add(7);
            arr.add(7);
            territory_distro = arr;
        }
        else if (num_players == 5) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(8);
            arr.add(8);
            arr.add(8);
            arr.add(9);
            arr.add(9);
            Collections.shuffle(arr);
            territory_distro = arr;
        }
        else {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(21);
            arr.add(21);
            territory_distro = arr;
        }
    }

    private ArrayList<Player> player_creation(ArrayList<Player> players,
                                         int num_players,
                                         List<String> names,
                                         List<String> colors){
        for (int i = 0; i < num_players; i++){
            String current_name = names.get(i);
            String current_color = colors.get(i);
            // preset all remaining armies to zero for now
            Player curr_player = new Player(i, current_name, current_color, 0);
            players.add(curr_player);
        }
        return players;
    }

    private int army_distributor(int num_players) {
        if (num_players == 2){
            return 40;
        }
        else if (num_players == 3){
            return 35;
        }
        else if (num_players == 4){
            return 30;
        }
        else if (num_players == 5){
            return 25;
        }
        else {
            return 20;
        }
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
