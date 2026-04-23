# Risk User Stories

## User Story 1: Start New Game

**As a player of Risk, I want the game to automatically set up the world map, assign territories, distribute initial armies, and determine the starting turn order when a new game begins, so that all players can begin the strategy game fairly without manually organizing the board and pieces.**

### Acceptance Criteria

- The game must not start unless there are **2 to 6 players**.
- Each player must be assigned a **unique color/faction**.
- All **42 territories** must be distributed among the players at the start of the game.
- Every territory must belong to **exactly one player**.
- Each territory must begin with **at least 1 army** stationed on it.
- The system must give each player the correct number of **initial armies** based on the total number of players.
- After territories are assigned, players must be allowed to place their remaining starting armies on territories they own.
- The system must determine and initialize the **turn order** before the first turn begins.
- The game must begin in the **reinforcement phase** of the first player.

### Actor
- Player

### Preconditions
- The game application is launched.
- No other game is currently in progress.

### Main Flow
1. Player clicks **“Start Game.”**
2. System asks for the number of players.
3. Players enter the total number of players.
4. System optionally asks for player names and/or lets each player choose a color.
5. System validates that the number of players is between 2 and 6.
6. System initializes the game board with all 42 territories.
7. System randomly determines which player receives each territory.
8. System places 1 army on each assigned territory.
9. System calculates each player’s total starting armies based on the player count.
10. System subtracts the armies already placed on owned territories from each player’s total starting army pool.
11. System allows players, in turn order or setup order, to place their remaining starting armies on territories they own until all starting armies are placed.
12. System determines the starting player and initializes the full turn order.
13. System starts the game with the first player’s reinforcement phase.

### Alternate Flows
- **5.a** The system detects that the entered number of players is invalid.  
- **5.b** The system displays an error message indicating that Risk requires 2 to 6 players.  
- **5.c** The system asks the user to re-enter the number of players.  
- **5.d** Resume at Step 2.  

- **4.a** Two players choose the same color.  
- **4.b** The system indicates that colors must be unique.  
- **4.c** The affected player must choose another available color.  
- **4.d** Resume at Step 4.  

- **11.a** A player attempts to place an army on a territory they do not own.  
- **11.b** The system rejects the move and displays an error message.  
- **11.c** The player must choose one of their own territories.  
- **11.d** Resume at Step 11.

### Postconditions
- All players have been registered and assigned unique colors.
- All 42 territories are assigned to players.
- Each territory contains at least 1 army.
- All players have placed their full starting armies.
- The turn order has been initialized.
- The game is ready for the first player to begin their turn.

---

## User Story 2: Reinforcement Phase

### Acceptance Criteria
- At the start of a player’s turn, the system must calculate reinforcements automatically.
- A player must receive reinforcement armies based on the number of territories they control, with a minimum reinforcement amount applied.
- If a player controls an entire continent, the corresponding continent bonus must be added.
- Reinforcement armies must only be placed on territories owned by the current player.
- The player must place all reinforcement armies before moving to the attack phase.
- The player must not be allowed to place reinforcement armies on enemy territories.

### Actor
- Current Player

### Preconditions
- A game is already in progress.
- It is the player’s turn.
- The previous player’s turn has ended.

### Main Flow
1. System starts the current player’s turn.
2. System counts the number of territories controlled by the player.
3. System calculates the player’s base reinforcement armies.
4. System checks whether the player controls any entire continent.
5. System adds any continent bonus armies to the player’s reinforcement total.
6. System displays the total number of reinforcement armies available.
7. Player selects one of their owned territories.
8. Player places one or more reinforcement armies onto that territory.
9. System updates the army count on the selected territory.
10. Player repeats army placement until all reinforcement armies are used.
11. Once all armies are placed, system advances to the attack phase.

### Alternate Flows
- **7.a** Player selects a territory not owned by them.  
- **7.b** System rejects the action and displays an error message.  
- **7.c** Player must select one of their own territories.  
- **7.d** Resume at Step 7.  

- **10.a** Player attempts to end the reinforcement phase before placing all armies.  
- **10.b** System prevents the phase from ending.  
- **10.c** Player must place all remaining reinforcement armies.  
- **10.d** Resume at Step 7.

### Postconditions
- The player has received the correct number of reinforcement armies.
- All reinforcement armies have been placed on valid territories.
- The game is ready for the attack phase.

---

## User Story 3: Attack Territory

### Acceptance Criteria
- A player may only attack from a territory they own.
- A player may only attack a territory adjacent to the attacking territory.
- A player may only attack if the attacking territory has more than 1 army.
- The defender must roll the correct number of defense dice based on their army count.
- The attacker must roll the correct number of attack dice based on their army count.
- Dice results must be compared from highest to highest, then second highest to second highest when applicable.
- Armies must be removed according to the dice comparison results.
- If the defending territory loses all armies, ownership of that territory must transfer to the attacker.
- The attacker must move at least the required number of armies into the conquered territory.
- The player may continue attacking or choose to stop and move to fortification.

### Actor
- Current Player

### Preconditions
- It is the current player’s turn.
- The reinforcement phase is complete.
- The player controls at least one territory with more than 1 army adjacent to an enemy territory.

### Main Flow
1. Player chooses to start an attack.
2. Player selects one owned territory as the attacking territory.
3. Player selects an adjacent enemy territory as the defending territory.
4. System validates that the territories are adjacent and owned by different players.
5. System checks that the attacking territory has more than 1 army.
6. Player chooses the number of attack dice to roll, within the allowed limit.
7. Defender chooses the number of defense dice to roll, within the allowed limit.
8. System rolls the attack and defense dice.
9. System sorts both sets of dice from highest to lowest.
10. System compares the highest dice pairs.
11. System removes armies from the loser of each comparison.
12. If the defending territory still has armies remaining, player may choose to attack again or stop attacking.
13. If the defending territory has no armies remaining, system transfers ownership of the territory to the attacker.
14. Player moves the required number of armies from the attacking territory into the conquered territory.
15. Player may choose to continue attacking from any valid territory or end the attack phase.

### Alternate Flows
- **4.a** Selected territories are not adjacent.  
- **4.b** System rejects the attack and displays an error message.  
- **4.c** Resume at Step 2.  

- **5.a** The attacking territory has only 1 army.  
- **5.b** System rejects the attack because at least 1 army must remain behind.  
- **5.c** Resume at Step 2.  

- **7.a** Defender has only 1 army and attempts to roll 2 dice.  
- **7.b** System rejects the selection and limits the defender to 1 die.  
- **7.c** Resume at Step 7.  

- **14.a** Player attempts to move fewer armies than required into the conquered territory.  
- **14.b** System rejects the move and displays an error message.  
- **14.c** Player must move a valid number of armies.  
- **14.d** Resume at Step 14.

### Postconditions
- Army counts are updated correctly after each battle.
- Conquered territories, if any, are reassigned correctly.
- Eliminated players, if any, no longer control territories.
- The player may continue attacking or proceed to fortification.

---

## User Story 4: Fortify Position

### Acceptance Criteria
- A player may fortify only once per turn.
- A player may move armies only between two territories they own.
- The two territories must be connected by a path of territories owned by the same player.
- At least 1 army must remain behind in the source territory.
- The system must update army counts correctly after fortification.
- After fortification is complete or skipped, the turn must pass to the next player.

### Actor
- Current Player

### Preconditions
- It is the current player’s turn.
- The attack phase is complete or skipped.
- The player has at least two connected territories.

### Main Flow
1. System enters the fortification phase.
2. Player chooses whether to fortify or skip.
3. If player chooses to fortify, player selects a source territory they own.
4. Player selects a destination territory they own.
5. System verifies that the two territories are connected through owned territories.
6. Player chooses how many armies to move.
7. System checks that at least 1 army will remain in the source territory.
8. System subtracts the chosen armies from the source territory.
9. System adds the chosen armies to the destination territory.
10. System ends the fortification phase.
11. System passes the turn to the next player.

### Alternate Flows
- **5.a** The source and destination territories are not connected through owned territories.  
- **5.b** System rejects the move and displays an error message.  
- **5.c** Resume at Step 3.  

- **7.a** Player attempts to move all armies out of the source territory.  
- **7.b** System rejects the move because one army must remain behind.  
- **7.c** Resume at Step 6.  

- **2.a** Player chooses to skip fortification.  
- **2.b** System ends the fortification phase immediately.  
- **2.c** Resume at Step 11.

### Postconditions
- If fortification occurred, armies are moved correctly between valid territories.
- The player’s turn ends.
- The next player’s turn begins.

---

## User Story 5: Eliminate a Player

### Acceptance Criteria
- A player must be eliminated immediately after losing their last territory.
- An eliminated player must no longer take turns.
- Ownership of the eliminated player’s territories must already have been transferred through conquest.
- The system must update the active player list after elimination.
- If only one player remains, the system must declare that player the winner.

### Actor
- Current Player / System

### Preconditions
- A game is in progress.
- A defending player has just lost a territory through attack.

### Main Flow
1. System checks whether the defending player still owns any territories.
2. If the defending player owns no territories, system marks that player as eliminated.
3. System removes the eliminated player from future turn order.
4. System updates the active player list.
5. System checks how many players remain in the game.
6. If more than one player remains, the game continues.
7. If only one player remains, system declares the remaining player the winner.

### Alternate Flows
- **1.a** The defending player still owns at least one territory.  
- **1.b** No elimination occurs.  
- **1.c** Game continues normally.

### Postconditions
- Eliminated players are removed from the active game.
- Remaining players continue in correct turn order.
- If one player remains, the game ends.

---

## User Story 6: Win the Game

### Acceptance Criteria
- The system must continuously track territory ownership.
- A player wins when they control all territories on the map.
- Once a winner is determined, no additional turns or actions may occur.
- The system must clearly display the winner.
- The game must enter an ended state after victory is declared.

### Actor
- System

### Preconditions
- A game is in progress.
- Territory ownership has just changed due to conquest or elimination.

### Main Flow
1. System checks whether a single player controls all territories on the map.
2. If one player controls all territories, system declares that player the winner.
3. System displays the winner to all players.
4. System ends the game.

### Alternate Flows
- **1.a** More than one player still controls territories.  
- **1.b** System does not end the game.  
- **1.c** Play continues normally.

### Postconditions
- The winner is declared.
- The game is ended.
- No further player actions are allowed.
