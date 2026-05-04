# TerritoryAdjacencyService BVA

### Method under test: `areAdjacent(Territory a, Territory b)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_areAdjacent_knownAdjacent  | Two known adjacent territories (Alaska, Alberta) | true | :white_check_mark: |
| TC2_areAdjacent_bidirectional  | Same pair reversed (Alberta, Alaska) | true | :white_check_mark: |
| TC3_areAdjacent_nonAdjacent  | Non-adjacent pair (Alaska, Brazil) | false | :white_check_mark: |
| TC4_areAdjacent_sameTerritory  | Same territory compared to itself (Alaska, Alaska) | false | :white_check_mark: |

### Method under test: `initializeTerritoryAdjacency(List<Territory> list)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC5_initialize_nullList  | `list == null` | throws IllegalArgumentException | :white_check_mark: |
| TC6_initialize_duplicateNames  | list contains duplicate-name territories | throws IllegalArgumentException | :white_check_mark: |

### Method under test: `getAdjacentTerritories(Territory t)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC7_getAdjacent_afterInitialize  | adjacency initialized with relevant neighbors | returns expected neighbor list (contains NW Territory, Alberta, Kamchatka for Alaska) | :white_check_mark: |
| TC8_getAdjacent_noDuplicates  | adjacency initialized for all territories | returned list has no duplicates | :white_check_mark: |
| TC9_getAdjacent_allTerritoriesHaveAdjacency  | adjacency initialized for all 42 territories | each territory has adjacency entries matching catalog size | :white_check_mark: |
| TC10_getAdjacent_whenNotInitialized  | adjacency not initialized | returns empty list | :white_check_mark: |

### Method under test: `createAllTerritories()`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC11_createAll_assignsContinents  | fresh call to createAllTerritories() | territories contain correct continents for sample names (Alaska, Brazil, Ukraine, Egypt, India, Indonesia) | :white_check_mark: |
| TC12_createAll_returns42Unique  | fresh call | returns 42 territories with unique names | :white_check_mark: |

### Method under test: `findByName(List<Territory>, String name)`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC13_findByName_found  | list contains named territory (Alaska) | returns matching Territory with correct continent | :white_check_mark: |
| TC14_findByName_nullOrBlankName  | name is null/blank | throws IllegalArgumentException | :white_check_mark: |
| TC15_findByName_missingName  | name not present in list | throws IllegalArgumentException | :white_check_mark: |
| TC16_findByName_nullList  | territory list is null | throws IllegalArgumentException | :white_check_mark: |

