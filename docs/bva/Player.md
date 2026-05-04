# Player BVA

### Method under test: constructors, setters and controlled-territory methods

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_allArgsConstructor_setsAllFields  | new Player(1, "Alice", "Red", 5, new ArrayList<>()) | fields set accordingly | :white_check_mark: |
| TC2_setters_updateValues  | setId/setName/setColor/setRemainingArmiesToPlace with valid values | getters reflect updated values | :white_check_mark: |
| TC3_setId_negative  | setId(-1) | throws IllegalArgumentException | :white_check_mark: |
| TC4_setName_nullOrBlank  | setName(null/""/"   ") | throws IllegalArgumentException | :white_check_mark: |
| TC5_setColor_nullOrBlank  | setColor(null/""/"   ") | throws IllegalArgumentException | :white_check_mark: |
| TC6_setRemainingArmies_negative  | setRemainingArmiesToPlace(-1) | throws IllegalArgumentException | :white_check_mark: |
| TC7_constructor_invalidArgs  | new Player(-1, "", "", -1, ...) | throws IllegalArgumentException | :white_check_mark: |

### Method under test: controlled territories API

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC8_parameterizedConstructor_initializesEmptyControlledTerritories  | new Player(...) | getControlledTerritories() not null and count == 0 | :white_check_mark: |
| TC9_addControlledTerritory_addsTerritory  | addControlledTerritory(valid Territory) | territory present, count increases | :white_check_mark: |
| TC10_addControlledTerritory_nullDoesNothing  | addControlledTerritory(null) | no change | :white_check_mark: |
| TC11_addControlledTerritory_noDuplicates  | add same Territory twice | added only once | :white_check_mark: |
| TC12_addControlledTerritory_multiple  | add several different territories | all are present and count matches | :white_check_mark: |
| TC13_setControlledTerritories_replacesList  | setControlledTerritories(newList) | player's list replaced and order preserved | :white_check_mark: |
| TC14_setControlledTerritories_nullCreatesEmpty  | setControlledTerritories(null) | creates empty list, count==0, not null | :white_check_mark: |
| TC15_setControlledTerritories_deepCopy  | setControlledTerritories(originalList) then mutate originalList | player's list unaffected | :white_check_mark: |
| TC16_setControlledTerritories_emptyListCreatesEmpty  | setControlledTerritories(emptyList) | player's list empty | :white_check_mark: |
| TC17_getControlledTerritories_returnsCorrectList  | after additions | returned list contains expected territories | :white_check_mark: |
| TC18_getControlledTerritoryCount_correctCount  | after additions | getControlledTerritoryCount returns accurate count | :white_check_mark: |
