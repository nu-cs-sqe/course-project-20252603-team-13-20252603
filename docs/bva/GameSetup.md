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
|                                  | State of the System    | Expected output             | Implemented?             |
|----------------------------------|------------------------|-----------------------------|--------------------------|
| TC1_ValidateMinimumSizeGame      | playerCount is 2       | The playerCount is accepted | :white_checkmark:        |
| TC2_ValidateBelowMinimumSizeGame | playerCount is 1       | The playerCount is rejected | :white_checkmark:        |
| TC3_ValidateMaximumSizeGame      | playerCount is 6       | The playerCount is accepted | :white_checkmark:        |
| TC4_ValidateAboveMaximumSizeGame | playerCount is 7       | The playerCount is rejected | :white_checkmark:        |
| TC5_ValidateINT_MAX              | playerCount is INT_MAX | The playerCount is rejected | :white_checkmark:        |
| TC6_ValidateINT_MIN              | playerCount is INT_MIN | The playerCount is rejected | :white_checkmark: |
| TC7_ValidateInRangeOfValidGame   | playerCount is 4       | The playerCount is accepted | :heavy_multiplication_x: |

