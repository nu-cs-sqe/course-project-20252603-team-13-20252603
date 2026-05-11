# BVA Analysis for GameController

### Method under test: `orchestration`
- **TC1: shouldInitializeTurnOrderAfterSetup** (black-box test)
    - **State of the system**: GameController, 2 colors and players, checking turnorder is not null
    - **Expected output**: True
- implemented: yes

- **TC2: shouldSetCurrentPlayerToFirstPlayerInTurnOrder** (black-box test)
    - **State of the system**: GameController, 2 colors and players, checking turnorder is correct
    - **Expected output**: True
- implemented: yes

- **TC3: shouldSetGamePhaseToReinforcementWhenSetupCompletes** (black-box test)
    - **State of the system**: GameController, 2 colors and players, checking phase is Reinforcement
    - **Expected output**: True
- implemented: yes

- **TC4: shouldReturnFullyInitializedGameState** (black-box test)
    - **State of the system**: GameController, 2 colors and players, checks the correct number of players and territories
    - **Expected output**: True
- implemented: yes

# Game Setup BVA

### Method under test: validatePlayerCount
|                                                          | State of the System    | Expected output                                                   | Implemented?       |
|----------------------------------------------------------|------------------------|-------------------------------------------------------------------|--------------------|
| TC1_ValidateMinimumSizeGame                              | playerCount is 2       | The playerCount is accepted                                       | :white_check_mark: |
| TC2_ValidateBelowMinimumSizeGame                         | playerCount is 1       | The playerCount is rejected                                       | :white_check_mark: |
| TC3_ValidateMaximumSizeGame                              | playerCount is 6       | The playerCount is accepted                                       | :white_check_mark: |
| TC4_ValidateAboveMaximumSizeGame                         | playerCount is 7       | The playerCount is rejected                                       | :white_check_mark: |
| TC5_ValidateINT_MAX                                      | playerCount is INT_MAX | The playerCount is rejected                                       | :white_check_mark: |
| TC6_ValidateINT_MIN                                      | playerCount is INT_MIN | The playerCount is rejected                                       | :white_check_mark: |
| TC7_ValidateInRangeOfValidGame                           | playerCount is 4       | The playerCount is accepted                                       | :white_check_mark: |
| TC8_shouldInitializeTurnOrderAfterSetup                  | playerCount is 2       | The turnOrder is not Null                                         | :white_check_mark: |
| TC9_shouldSetCurrentPlayerToFirstPlayerInTurnOrder       | playerCount is 2       | The firstTurn is the first player                                 | :white_check_mark: |
| TC10_shouldSetGamePhaseToReinforcementWhenSetupCompletes | playerCount is 2       | GamePhase is REINFORCEMENT                                        | :white_check_mark: |
| TC11_shouldReturnFullyInitializedGameState               | playerCount is 2       | Finished gameState: players, territories, turnorder, are not null | :white_check_mark: |

