# Territory BVA

### Method under test: constructors and setters/getters

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_allArgsConstructor_setsAllFields  | new Territory(name, owner, armyCount, continent) with valid args | fields set accordingly | :white_check_mark: |
| TC2_setters_updateValues  | default Territory(), then setName/setOwner/setArmyCount/setContinent | getters reflect updated values | :white_check_mark: |
| TC3_setOwner_allowsNull  | territory.setOwner(null) | getOwner() == null | :white_check_mark: |
| TC4_setArmyCount_negative  | setArmyCount(-1) | throws IllegalArgumentException | :white_check_mark: |
| TC5_constructor_negativeArmy  | new Territory("Alaska", owner, -1, Continent.NORTH_AMERICA) | throws IllegalArgumentException | :white_check_mark: |
