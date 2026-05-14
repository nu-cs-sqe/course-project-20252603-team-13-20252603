### Method under test: shouldReturnZeroBonusWhenPlayerControlsNoFullContinent
|                                           | State of the System                                     | Expected output | Implemented?       |
|-------------------------------------------|---------------------------------------------------------|-----------------|--------------------|
| TC1:Player_Doesn't_Control_Full_Continent | 1 Player: controls 5/6 territories in Africa, 1 in Asia | 0 Bonus armies  | :white_check_mark: |

### Method under test: shouldReturnCorrectBonusWhenPlayerControlsOneContinent
|                              | State of the System                                | Expected output | Implemented?       |
|------------------------------|----------------------------------------------------|-----------------|--------------------|
| TC1:Control_Of_Africa        | Player controls all 6 territories of Africa        | 3 bonus armies  | :white_check_mark: |
| TC2:Control_Of_Australia     | Player controls all 4 territories of Australia     | 2 bonus armies  | :white_check_mark: |
| TC3:Control_Of_South_America | Player controls all 4 territories of South America | 2 bonus armies  | :white_check_mark: |
| TC4:Control_Of_North_America | Player controls all 9 territories of North America | 5 bonus armies  | :white_check_mark: |
| TC5:Control_Of_Europe        | Player controls all 7 territories of Europe        | 5 bonus armies  | :white_check_mark: |
| TC6:Control_Of_Asia          | Player controls all 12 territories of Asia         | 7 bonus armies  | :white_check_mark: |

### Method under test: shouldReturnCombinedBonusWhenPlayerControlsMultipleContinents
|                                 | State of the System                                      | Expected output | Implemented?         |
|---------------------------------|----------------------------------------------------------|-----------------|----------------------|
| TC6:Control_Of_Africa_Australia | Player controls all 10 territories of Africa & Australia | 5 bonus armies  | :white_check_mark:   |

### Method under test: shouldNotGrantBonusWhenOneTerritoryInContinentIsOwnedByAnotherPlayer
|      | State of the System                                       | Expected output | Implemented?             |
|------|-----------------------------------------------------------|-----------------|--------------------------|
| TC1: | Player 1 controls 3/4 of Australia, Player 2 controls 1/4 | 0 armies        | :white_check_mark:       |
