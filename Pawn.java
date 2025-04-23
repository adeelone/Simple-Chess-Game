public class Pawn extends Piece {
    public Pawn(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int forwardDirection = (color.equals("WHITE")) ? -1 : 1; // White moves up, Black moves down
        int rowDiff = newPosition.getRow() - position.getRow() * forwardDirection;
        int colDiff = newPosition.getCol() - position.getCol() * forwardDirection;

        if(colDiff ==0 && rowDiff == 1 && board[newPosition.getRow()][newPosition.getCol()] == null) {
            return true; // Move forward by one square
        } else if(colDiff == 0 && rowDiff == 2 && position.getRow() == (color.equals("WHITE") ? 1 : 6) && board[newPosition.getRow()][newPosition.getCol()] == null) {
            return true; // Move forward by two squares from starting position
        } else if(Math.abs(colDiff) == 1 && rowDiff == 1 && board[newPosition.getRow()][newPosition.getCol()] != null) {
            return true; // Capture diagonally
        }
        return false; // Invalid move
    }
}
