# TerritoryAssignmentService BVA

### Method under test: `findTerritoryByName(GameState state, String name)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_findTerritory_exists  | GameState has Territory Alaska | returns same Territory object | :white_check_mark: |
| TC2_findTerritory_notFound  | GameState has empty territory list | throws IllegalArgumentException | :white_check_mark: |

### Method under test: `playerOwnsTerritory(Player p, GameState state, String territoryName)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC3_playerOwns_true  | Territory owner id matches player id | true | :white_check_mark: |
| TC4_playerOwns_differentPlayer  | Territory owned by different player | false | :white_check_mark: |

### Method under test: `assignArmyToTerritory(GameState state, Player player, String name, int armies)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC5_assignArmy_success  | Player owns territory with 5 remaining armies, territory has 2 armies, assign 3 | territory army becomes 5, player remaining becomes 2 | :white_check_mark: |
| TC6_assignArmy_notEnough  | Player has fewer armies than requested (2) | throws IllegalArgumentException | :white_check_mark: |
| TC7_assignArmy_playerDoesNotOwn  | Player does not own territory | throws IllegalArgumentException | :white_check_mark: |

### Method under test: `assignTerritoryToPlayer(Territory territory, Player player)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC8_assignTerritory_setsOwner  | territory owner null, valid player | territory.getOwner() == player | :white_check_mark: |

### Method under test: `assignTerritories(GameState state)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC9_assignTerritories_count42  | state with 4 players | state.getTerritories().size() == 42 and each territory has 1 army | :white_check_mark: |
| TC10_assignTerritories_noDuplicates  | state with 2 players | all territory names unique, 42 unique names | :white_check_mark: |
| TC11_assignTerritories_distribution4Players  | 4 players | controlled counts 11,11,10,10 | :white_check_mark: |
| TC12_assignTerritories_distribution3Players  | 3 players | controlled counts 14,14,14 | :white_check_mark: |
| TC13_assignTerritories_distribution2Players  | 2 players | controlled counts 21,21 | :white_check_mark: |
| TC14_assignTerritories_distribution5Players  | 5 players | controlled counts 9,9,8,8,8 | :white_check_mark: |
| TC15_assignTerritories_distribution6Players  | 6 players | controlled counts 7 each | :white_check_mark: |
| TC16_assignTerritories_noPlayers  | state.players is empty | throws IllegalArgumentException | :white_check_mark: |
| TC17_eachTerritory_hasOwner  | 2 players | each territory has non-null owner whose id matches player's id | :white_check_mark: |

### Method under test: `placeInitialOneArmyPerTerritory(GameState gameState)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC18_placeInitialOneArmy_emptyState | gameState has 0 territories assigned to any player | no territory army counts change | :x: |
| TC19_placeInitialOneArmy_singleTerritory | gameState has 1 assigned territory with armyCount = 0 | that territory's armyCount becomes 1 | :x: |
| TC20_placeInitialOneArmy_multipleTerritories | gameState has 2 assigned territories with armyCount values 0 and 0 | both territories' armyCount values become 1 | :x: |
| TC21_placeInitialOneArmy_maxTerritories | gameState has 42 assigned territories, each with armyCount = 0 | all 42 territories end with armyCount = 1 | :x: |

