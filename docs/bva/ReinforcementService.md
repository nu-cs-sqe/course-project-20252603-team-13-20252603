### Method under test: calculateBaseReinforcements(Player player, GameState gameState)
|                                         | State of the System             | Expected output | Implemented?           |
|-----------------------------------------|---------------------------------|-----------------|------------------------|
| TC1: Minimum return for low territories | Player controls 2 territories   | 3 armies        | :white_check_mark:     |
| TC2: 9_territories_3_armies             | player controls 9 territories   | 3 armies        | :white_check_mark:     |
| TC3:Lowest_Boundary                     | player controls 1 territories   | 3 armies        | :white_check_mark:     |
| TC4: 9/3                                | player controls 9 territories   | 3 armies        | :white_check_mark:     |
| TC5: Below_Boundary 2                   | player controls 11 territories  | 3 armies        | :white_check_mark:     |
| TC6: Above_Boundary 2                   | player controls 12 territories  | 4 armies        | :white_check_mark:     |
| TC7: Below_Boundary 3                   | player controls 14 territories  | 4 armies        | :white_check_mark:     |
| TC8: Above_Boundary 3                   | player controls 15 territories  | 5 armies        | :white_check_mark:     |
| TC9: Below_Boundary 4                   | player controls 17 territories  | 5 armies        | :white_check_mark:     |
| TC10: Above_Boundary 4                  | player controls 18 territories  | 6 armies        | :white_check_mark:     |
| TC11: Below_Boundary 5                  | player controls 20 territories  | 6 armies        | :white_check_mark:     |
| TC12: Above_Boundary 5                  | player controls 21 territories  | 7 armies        | :white_check_mark:     |
| TC13: Below_Boundary 6                  | player controls 23 territories  | 7 armies        | :white_check_mark:     |
| TC14: Above_Boundary 6                  | player controls 24 territories  | 8 armies        | :white_check_mark:     |
| TC15: Below_Boundary 7                  | player controls 26 territories  | 8 armies        | :white_check_mark:     |
| TC16: Above_Boundary 7                  | player controls 27 territories  | 9 armies        | :white_check_mark:     |
| TC17: Below_Boundary 8                  | player controls 29 territories  | 9 armies        | :white_check_mark:     |
| TC18: Above_Boundary 8                  | player controls 30 territories  | 10 armies       | :white_check_mark:     |
| TC19:Below_Boundary 9                   | player controls 32 territories  | 10 armies       | :white_check_mark:     |
| TC20: Above_Boundary 9                  | player controls 33 territories  | 11 armies       | :white_check_mark:     |
| TC21: Below_Boundary 10                 | player controls 35 territories  | 11 armies       | :white_check_mark:     |
| TC22: Above_Boundary 10                 | player controls 36 territories  | 12 armies       | :white_check_mark:     |
| TC23: Below_Boundary 11                 | player controls 38 territories  | 12 armies       | :white_check_mark:     |
| TC24: Above_Boundary 11                 | player controls 39 territories  | 13 armies       | :white_check_mark:     |
| TC25: Below_Boundary 12                 | player controls 41 territories  | 13 armies       | :white_check_mark:     |
| TC26: Above_Boundary 12                 | player controls 42 territories  | 14 armies       | :white_check_mark:     |