# Minesweeper Console Game (Java)

This is a text-based version of Minesweeper written in Java. It was developed as a personal and academic project to apply core programming concepts like arrays, loops, user input, and game logic in a console environment.

## Features

- Custom board size (1x1 to 10x10)
- Choose the number of bombs (1–30, validated to avoid overfilling)
- Random bomb placement
- Input validation for coordinates and setup
- Displays adjacent bomb count for each safe tile
- Game ends on bomb reveal or when all safe spaces are cleared
- Option to restart or exit at the end of each game

## How It Works

The game initializes two boards:
- A **hidden board** containing bomb locations and number placeholders
- A **visible board** shown to the user, initialized with `x` for unexplored tiles

Each turn, the player selects coordinates. If a bomb is revealed, the game ends. If the tile is safe, the number of adjacent bombs is calculated and displayed. The game continues until the player wins or hits a bomb.

## Technologies Used

- Java (Java SE, written and tested using IntelliJ IDEA)
- Scanner for console input
- 2D arrays and nested loops for board logic
- Basic terminal UI output

## What I Learned

- Designing and managing 2D arrays for stateful game logic
- Randomized bomb placement and input validation techniques
- Structuring code into modular, reusable methods
- Building a simple console-based game loop
- This was also my first time using Git and GitHub. I used this project to learn how to structure a repository, write commit messages, and push code from IntelliJ to a remote repo. It gave me a better understanding of version control and how teams manage code in real-world software development.

## Potential Improvements

There are several features that were considered during planning but not implemented in this version:

- Recursive reveal of empty tiles (auto-clear 0-bomb zones)
- Tile-flagging system for suspected bombs
- High score tracking (e.g., win streak or time taken)
- GUI implementation using JavaFX or Swing
- Difficulty presets (Easy/Medium/Hard)
- Better formatting and coordinate grid display

These ideas were deferred to keep the scope of the project manageable and focused on core logic.

## How to Run

1. Clone or download this repository
2. Open the project in IntelliJ IDEA (or another Java IDE)
3. Run the `MineSweeper` class
4. Follow the console prompts to play

## Contact

Wesley Deir  
Email: deir0006@algonquinlive.com