# Territory BVA

### Method under test: constructors and setters/getters

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_allArgsConstructor_setsAllFields  | new Territory(name, owner, armyCount, continent) with valid args | fields set accordingly | :white_check_mark: |
| TC2_setters_updateValues  | default Territory(), then setName/setOwner/setArmyCount/setContinent | getters reflect updated values | :white_check_mark: |
| TC3_setOwner_allowsNull  | territory.setOwner(null) | getOwner() == null | :white_check_mark: |
| TC4_setName_withNullOrBlank  | setName(null/""/"   ") | throws IllegalArgumentException | :white_check_mark: |
| TC5_setArmyCount_negative  | setArmyCount(-1) | throws IllegalArgumentException | :white_check_mark: |
| TC6_setContinent_null  | setContinent(null) | throws IllegalArgumentException | :white_check_mark: |
| TC7_constructor_invalidArgs  | new Territory(null/""/negative army/null continent) | throws IllegalArgumentException | :white_check_mark: |
