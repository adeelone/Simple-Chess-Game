# Java Chess Game

## Description
This Java project is an implementation of the classic game of chess. It provides a full-fledged chess application with a graphical user interface, allowing users to play the game on their local machines.

## Features
- Interactive chessboard and chess piece visualization
- Accurate implementation of chess rules, including valid move generation, check detection, and checkmate/stalemate handling
- User-friendly interface with intuitive controls for selecting pieces and making moves
- Game state management, including tracking player turns, legal moves, and game-ending conditions
- Optional game reset functionality

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed on your system
- An Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans

### Installation
1. Clone the repository or download the source code as a ZIP file.
2. Open the project in your preferred IDE.
3. Ensure the project is configured to use the appropriate JDK version.
4. Build and run the `ChessGameGUI` class to launch the application.

### Usage
1. The application will display an interactive chessboard with the initial chess piece positions.
2. Click on a piece to select it, and then click on a valid destination square to move the piece.
3. The game will automatically handle turn-taking, check detection, and checkmate/stalemate conditions.
4. To reset the game, use the "Reset" button in the application window.

## Development
The project is structured as follows:

- `Piece`: An abstract class representing a chess piece, with subclasses for each piece type (Pawn, Rook, Knight, Bishop, Queen, King).
- `ChessGame`: The main game logic class, responsible for managing the chessboard, player turns, and game-ending conditions.
- `ChessGameGUI`: The graphical user interface class, built using Java Swing, that provides the visual representation of the chess game.
- `ChessSquareComponent`: A custom Swing component representing a single square on the chessboard.
