# Game Setup BVA

### Method under test: validatePlayerCount
|                                  | State of the System    | Expected output             | Implemented?             |
|----------------------------------|------------------------|-----------------------------|--------------------------|
| TC1_ValidateMinimumSizeGame      | playerCount is 2       | The playerCount is accepted | :white_check_mark:        |
| TC2_ValidateBelowMinimumSizeGame | playerCount is 1       | The playerCount is rejected | :white_check_mark:        |
| TC3_ValidateMaximumSizeGame      | playerCount is 6       | The playerCount is accepted | :white_check_mark:        |
| TC4_ValidateAboveMaximumSizeGame | playerCount is 7       | The playerCount is rejected | :white_check_mark:        |
| TC5_ValidateINT_MAX              | playerCount is INT_MAX | The playerCount is rejected | :white_check_mark:        |
| TC6_ValidateINT_MIN              | playerCount is INT_MIN | The playerCount is rejected | :white_check_mark: |
| TC7_ValidateInRangeOfValidGame   | playerCount is 4       | The playerCount is accepted | :white_check_mark: |

