# 🏇 Knight Game

A strategic two-player board game implemented in Java Swing where players control knights that move in L-shapes to claim territory and achieve victory.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)

## 📖 Game Description

Knight Game is a turn-based strategy game played on a customizable board (4×4, 6×6, or 8×8). Two players control knights that move like chess knights, claiming squares by visiting them. The first player to create a line of 4 adjacent squares in their color wins!

### Game Rules

- **Setup**: Each player controls 2 knights placed at opposite corners
  - White knights: Top-left and Bottom-right
  - Black knights: Top-right and Bottom-left
  
- **Gameplay**:
  - Players alternate turns
  - Knights move in an L-shape (like in chess)
  - Visiting a square colors it with your color
  - You can "steal" opponent's colored squares
  - Knights cannot move onto squares occupied by other knights

- **Victory Conditions**:
  - Get 4 adjacent squares of your color (horizontal, vertical, or diagonal)
  - If the board fills with no winner, the game ends in a draw

- **Auto-restart**: After each game, a new game starts automatically

## 🎮 Features

- ✅ Multiple board sizes (4×4, 6×6, 8×8)
- ✅ Visual highlighting of valid moves
- ✅ Unicode knight symbols (♘ for white, ♞ for black)
- ✅ Color-coded game board (white, black, and grey squares)
- ✅ Turn indicator showing current player
- ✅ Automatic win detection
- ✅ Menu system (New Game, Exit)
- ✅ Clean GUI with Swing

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/knight-game.git
cd knight-game
```

2. Compile all Java files:
```bash
javac *.java
```

3. Run the game:
```bash
java KnightGame
```

## 🎯 How to Play

1. **Start the game**: Select your preferred board size when prompted
2. **Select a knight**: Click on one of your knights (shown in your color)
3. **Move the knight**: Click on a highlighted green square to move
4. **Claim territory**: The square you move to becomes your color
5. **Win the game**: Create 4 adjacent squares in your color!

### Controls

- **Left Click**: Select knight or move to highlighted square
- **Menu → New Game**: Start a new game with board size selection
- **Menu → Exit**: Close the application

## 📁 Project Structure

```
knight-game/
├── KnightGame.java      # Main launcher class
├── GameGUI.java         # Main application window and game flow
├── BoardGUI.java        # Board visualization panel
├── Game.java            # Game logic and rules
├── Board.java           # Board state and win detection
├── Knight.java          # Knight data and movement logic
├── Player.java          # Player data
└── README.md            # This file
```

### Class Responsibilities

- **KnightGame**: Entry point with main method
- **GameGUI**: Application window, menus, dialogs, and game orchestration
- **BoardGUI**: Visual representation of the game board
- **Game**: Game state management, turn control, and move validation
- **Board**: Board data structure and win condition checking
- **Knight**: Knight entity with movement calculation
- **Player**: Player entity with color and knight management

## 🏗️ Architecture

The project follows a clean MVC-inspired architecture:

- **Model**: `Knight`, `Player`, `Board`, `Game`
- **View**: `BoardGUI`
- **Controller**: `GameGUI`

This separation ensures maintainability and extensibility.

## 🎨 UI Preview

```
┌─────────────────────────────┐
│      Current Player: WHITE  │
├─────────────────────────────┤
│  ♞│   │   │   │   │   │ ♘ │
│────┼───┼───┼───┼───┼───┼────│
│    │   │   │   │   │   │    │
│────┼───┼───┼───┼───┼───┼────│
│    │   │   │   │   │   │    │
│────┼───┼───┼───┼───┼───┼────│
│  ♘│   │   │   │   │   │ ♞ │
├─────────────────────────────┤
│ Click knight to select...   │
└─────────────────────────────┘
```

## 🧪 Testing

The game has been tested with:
- ✅ All board sizes (4×4, 6×6, 8×8)
- ✅ Win conditions in all directions
- ✅ Draw conditions (full board)
- ✅ Knight collision detection
- ✅ Valid move highlighting
- ✅ Turn alternation

## 🛠️ Technical Details

- **Language**: Java 8+
- **GUI Framework**: Swing (JFrame, JPanel, JButton)
- **Design Pattern**: MVC-inspired architecture
- **Data Structures**: 2D arrays, ArrayList

## 📝 Assignment Context

This project was developed as a Java Programming Technology assignment focusing on:
- Object-oriented programming principles
- GUI development with Swing
- Game logic implementation
- Clean code architecture

## 🤝 Contributing

This is an academic project, but suggestions and improvements are welcome!

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/improvement`)
3. Commit your changes (`git commit -am 'Add improvement'`)
4. Push to the branch (`git push origin feature/improvement`)
5. Open a Pull Request

## 📄 License

This project is created for educational purposes.

## 👤 Author

Created as part of a Java Programming Technology course assignment.

## 🙏 Acknowledgments

- Chess knight movement rules
- Java Swing documentation
- Course instructor for the project specifications

---

**Enjoy the game! May the best strategist win!** 🏆