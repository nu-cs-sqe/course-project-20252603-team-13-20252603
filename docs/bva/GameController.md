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

