# Requirements Specification

## Functional Requirements:

*  Startpage
A homepage should be displayed when the game starts. The player should be welcomed and offered various game options along with a "Start Game" button.

* Game Options
The player should be able to choose between three levels of difficulty: easy (12x12), medium (20x20), and hard (30x30).
The choice of difficulty level should affect the size of the nonogram board.

* Starting The Game
The "Start Game" button should be displayed on the start page. After clicking this button, a game page is presented.

* Game Page
The game page should consist of the game board, "Check Solution", "Get Solution", and "Main Menu" buttons.

* Game Board:
A nonogram board should be generated based on the selected difficulty level.
The board should consist of white cells that the player can click on to fill in (black color) or mark (gray color with the letter “x”).
The number of cells on the board should match the level of difficulty (15x15, 30x30, 50x50).

* Interaction - game board
If the player clicks on a white nonogram cell, the cell is changes color to black. If the player clicks on a black cell, the cell changes color to grey and gets text "x". If the player clicks on a grey cell with text "x", the changes color to white and does not have any text.

* Nonogram Counts
Each row and column on the board should have nonogram counts to indicate the number of consecutive filled cells required.

* Interaction - nonogram counts
If the player clicks on a yellow nonogram counts cell, the cell is changes color from to grey. If the player clicks on a grey nonogram counts cell, the cell changes color to yellow.

* Solution Verification
When the player believes they have correctly filled all the necessary fields, they can press the "Check Solution" button. A message should then appear to inform the player whether the solution is correct or not.

* Solution Reveal
There should be a "Get Solution" feature that, when used, automatically fills in the correct cells on the board for the player.

*  Navigation
On the game page, a "Main Menu" button should be provided to allow the player to return to the main menu at any time.




## Non-Functional Requirements:
* Performance
The game should be fast and responsive.
Loading times should be minimal.

* Reliability
The game should be stable and not crash.

