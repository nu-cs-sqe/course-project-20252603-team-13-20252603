# GameState BVA

### Method under test: constructor and getters/setters

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_constructor_initializesCollections  | new GameState() | players, territories, turnOrder are non-null empty lists | :white_check_mark: |
| TC2_settersAndGetters_updateAllFields  | setPlayers/setTerritories/setTurnOrder/setCurrentPlayer/setCurrentPhase with mocks | getters return same objects and sizes as expected; currentPlayer and phase set correctly | :white_check_mark: |

