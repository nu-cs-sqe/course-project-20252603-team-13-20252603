# TerritoryCatalog BVA

### Method under test: static data `TERRITORIES_BY_CONTINENT`

|              | State of the System | Expected output | Implemented?              |
|--------------|---------------------|-----------------|---------------------------|
| TC1_catalog_containsAllContinents  | static catalog loaded at runtime | map contains 6 continents as keys | :white_check_mark: |
| TC2_catalog_expectedCounts  | static catalog loaded | continent lists sizes match expected (NA=9, SA=4, EU=7, AF=6, AS=12, AU=4) | :white_check_mark: |

