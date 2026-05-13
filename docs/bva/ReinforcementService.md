### Method under test: shouldReturnMinimumReinforcementWhenPlayerOwnsFewTerritories
|      | State of the System           | Expected output | Implemented?             |
|------|-------------------------------|-----------------|--------------------------|
| TC1: | Player controls 2 territories | 3 armies        | :white_check_mark:       |

### Method under test: shouldCalculateBaseReinforcementFromTerritoryCount
|                            | State of the System           | Expected output | Implemented?         |
|----------------------------|-------------------------------|-----------------|----------------------|
| TC1_9_territories_3_armies | player controls 9 territories | 3 armies        | :white_check_mark:   |

### Method under test: shouldCalculateCorrectReinforcementAtBoundaryValues
|                        | State of the System            | Expected output | Implemented?             |
|------------------------|--------------------------------|-----------------|--------------------------|
| TC1_Lowest_Boundary    | player controls 1 territories  | 3 armies        | :white_check_mark:       |
| TC2_9/3                | player controls 9 territories  | 3 armies        | :white_check_mark:       |
| TC3_Below_Boundary 2   | player controls 11 territories | 3 armies        | :white_check_mark:       |
| TC4_Above_Boundary 2   | player controls 12 territories | 4 armies        | :white_check_mark:       |
| TC5_Below_Boundary 3   | player controls 14 territories | 4 armies        | :white_check_mark:       |
| TC6_Above_Boundary 3   | player controls 15 territories | 5 armies        | :white_check_mark:       |
| TC7_Below_Boundary 4   | player controls 17 territories | 5 armies        | :white_check_mark:       |
| TC8_Above_Boundary 4   | player controls 18 territories | 6 armies        | :white_check_mark:       |
| TC9_Below_Boundary 5   | player controls 20 territories | 6 armies        | :white_check_mark:       |
| TC10_Above_Boundary 5  | player controls 21 territories | 7 armies        | :white_check_mark:       |
| TC11_Below_Boundary 6  | player controls 23 territories | 7 armies        | :white_check_mark:       |
| TC12_Above_Boundary 6  | player controls 24 territories | 8 armies        | :white_check_mark:       |
| TC13_Below_Boundary 7  | player controls 26 territories | 8 armies        | :white_check_mark:       |
| TC14_Above_Boundary 7  | player controls 27 territories | 9 armies        | :white_check_mark:       |
| TC15_Below_Boundary 8  | player controls 29 territories | 9 armies        | :white_check_mark:       |
| TC16_Above_Boundary 8  | player controls 30 territories | 10 armies       | :white_check_mark:       |
| TC17_Below_Boundary 9  | player controls 32 territories | 10 armies       | :white_check_mark:       |
| TC18_Above_Boundary 9  | player controls 33 territories | 11 armies       | :white_check_mark:       |
| TC19_Below_Boundary 10 | player controls 35 territories | 11 armies       | :white_check_mark:       |
| TC20_Above_Boundary 10 | player controls 36 territories | 12 armies       | :white_check_mark:       |
| TC21_Below_Boundary 11 | player controls 38 territories | 12 armies       | :white_check_mark:       |
| TC22_Above_Boundary 11 | player controls 39 territories | 13 armies       | :white_check_mark:       |
| TC23_Below_Boundary 12 | player controls 41 territories | 13 armies       | :white_check_mark:       |
| TC24_Above_Boundary 12 | player controls 42 territories | 14 armies       | :white_check_mark:       |