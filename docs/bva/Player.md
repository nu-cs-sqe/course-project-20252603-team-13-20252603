# Player BVA

### Method under test: constructors, setters and controlled-territory methods

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_allArgsConstructor_setsAllFields  | new Player(1, "Alice", "Red", 5, new ArrayList<>()) | fields set accordingly | :white_check_mark: |
| TC2_setters_updateValues  | setId/setName/setColor/setRemainingArmiesToPlace with valid values | getters reflect updated values | :white_check_mark: |
| TC3_setId_negative  | setId(-1) | throws IllegalArgumentException | :white_check_mark: |
| TC4_setRemainingArmies_negative  | setRemainingArmiesToPlace(-1) | throws IllegalArgumentException | :white_check_mark: |

### Method under test: controlled territories API

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC5_parameterizedConstructor_initializesEmptyControlledTerritories  | new Player(...) | getControlledTerritories() not null and count == 0 | :white_check_mark: |
| TC6_addControlledTerritory_addsTerritory  | addControlledTerritory(valid Territory) | territory present, count increases | :white_check_mark: |
| TC7_addControlledTerritory_noDuplicates  | add same Territory twice | added only once | :white_check_mark: |
| TC8_addControlledTerritory_multiple  | add several different territories | all are present and count matches | :white_check_mark: |
| TC9_setControlledTerritories_replacesList  | setControlledTerritories(newList) | player's list replaced and order preserved | :white_check_mark: |
| TC10_setControlledTerritories_deepCopy  | setControlledTerritories(originalList) then mutate originalList | player's list unaffected | :white_check_mark: |
| TC11_setControlledTerritories_emptyListCreatesEmpty  | setControlledTerritories(emptyList) | player's list empty | :white_check_mark: |
| TC12_getControlledTerritories_returnsCorrectList  | after additions | returned list contains expected territories | :white_check_mark: |
| TC13_getControlledTerritoryCount_correctCount  | after additions | getControlledTerritoryCount returns accurate count | :white_check_mark: |
