# Nonogram Game Test Specification

## Functional Requirements Testing:

- 1.1 Start Page

Test Case 1.1.1: Display of Start Page (Requirements: 1, 2)
Input: 
* Launch the game

Expected Output: 
* The homepage is displayed with a name of the game text "NONOGRAM GAME" 
* Various game options are displayed: easy (12x12), medium (20x20), or hard (30x30)
* "Start Game" button is displayed

- 1.2 Starting The Game

Test Case 1.2.1: Clicking 'Start Game' (Requirements: 3, 4, 2, 5, 7)
Input: 
* Launch the game
* Click the "Start Game" button on the start page

Expected Output: 
* The game page is displayed
* Game board with 12 rows and 12 columns is presented
* Game cells are white and does not have any text
* Each row and column on the board have nonogram counts to indicate the number of consecutive filled cells required
* Check my solution button is presented
* Get soulution button is presented
* Main menu button is presented


- 1.3 Game Options

Test Case 1.3.1: Selecting Difficulty Level: medium (20x20) (Requirements: 2, 5, 7)
Input: 
* Launch the game
* Choose a difficulty level: medium (20x20)

Expected Output: 
* The game page is displayed
* Game board with 20 rows and 20 columns is presented
* Game cells are white and does not have any text
* Each row and column on the board have nonogram counts to indicate the number of consecutive filled cells required
* Check my solution button is presented
* Get soulution button is presented
* Main menu button is presented


Test Case 1.3.2: Selecting Difficulty Level: hard (30x30) (Requirements: 2, 5, 7)
Input: 
* Launch the game
* Choose a difficulty level: hard (30x30)

Expected Output:
* The game page is displayed
* Game board with 30 rows and 30 columns is presented
* Game cells are white and does not have any text
* Each row and column on the board have nonogram counts to indicate the number of consecutive filled cells required
* Check my solution button is presented
* Get soulution button is presented
* Main menu button is presented


- 1.4 Game Page interactions

Test Case 1.4.1: Clicking on a white cell (Requirements: 6)
Input: 
* Test Case 1.2.1
* Click on a white cell

Expected Output: 
* The cell that is clicked changed color to black


Test Case 1.4.2: Clicking on a black cell (Requirements: 6)
Input: 
* Test Case 1.2.1
* Click on a black cell

Expected Output: 
* The cell that is clicked changed color to grey
* The cell that is clicked has text "x" after the click


Test Case 1.4.3: Clicking on a grey cell with text "x" (Requirements: 6)
Input: 
* Test Case 1.2.1
* Click on a grey cell with text "x"

Expected Output: 
* The cell that is clicked changed color to white
* The cell that is clicked does not have any text


- 1.5 Interaction - nonogram Counts

Test Case 1.5.1: Clicking on a yellow nonogram counts cell (Requirements: 8)
* Test Case 1.2.1
* Click on a yellow nonogram counts cell

Expected Output: 
* The cell that is clicked changed color to grey


Test Case 1.5.2: Clicking on a grey nonogram counts cell (Requirements: 8)
* Test Case 1.2.1
* Click on a grey nonogram counts cell

Expected Output: 
* The cell that is clicked changed color to yellow


- 1.6 Solution Verification

Test Case 1.6.1: Verifying the Solution - right solution (Requirements: 9)
* Test Case 1.2.1
* Fill in all the cells correctly (Make correct grid of black and white cells)
* Press the "Check Solution" button

Expected Output: 
* Message: "Your solution is correct!" is presented


Test Case 1.6.2: Verifying the Solution - incorrect solution (Requirements: 9)
* Test Case 1.2.1
* Press once some random white cells
* Press the "Check Solution" button

Expected Output: 
* Message: "Your solution is not correct!" is presented


- 1.7 Solution Reveal

Test Case 1.7.1: Using 'Get Solution' Feature (Requirements: 10)
Input: 
* Test Case 1.2.1
* Click the "Get Solution" button

Expected Output: 
* The correct cells on the board are automatically filled in for the player
* Check that the game board has the correct number of black and white cells in relation to the nonogram counts


- 1.8 Navigation 

Test Case 1.8.1: Returning to Main Menu (Requirements: 11)
Input: 
* Test Case 1.2.1
* Click the "Main Menu" button on the game page.

Expected Output: 
* The homepage is displayed with a name of the game text "NONOGRAM GAME" 
* Various game options are displayed: easy (12x12), medium (20x20), or hard (30x30)
* "Start Game" button is displayed



## Non-Functional Requirements Testing:
- 2.1 Performance

Test Case 2.1.1: Game Responsivenes (Requirements: 12)
Input: 
* Various interactions with the game.

Expected Output: 
* The game is fast and responsive with minimal loading times.


- 2.2 Reliability

Test Case 2.2.1: Game Stability (Requirements: 13)
Input: 
* Extended gameplay.

Expected Output: 
* The game remains stable and does not crash.
