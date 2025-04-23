public class Bishop extends Piece {
    public Bishop(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(newPosition.equals(this.position)) {
            return false; // Invalid move if new position is null
        }
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());

        // Bishops move diagonally: equal row and column differences
        boolean isValidMove = (rowDiff == colDiff);
        if (!isValidMove) {
            return false; // Invalid move for a bishop
        }

        // Check if the path is clear diagonally
        int rowStep = (newPosition.getRow() > position.getRow()) ? 1 : -1;
        int colStep = (newPosition.getCol() > position.getCol()) ? 1 : -1;
        int currentRow = position.getRow() + rowStep;
        int currentCol = position.getCol() + colStep;

        while (currentRow != newPosition.getRow() && currentCol != newPosition.getCol()) {
            if (board[currentRow][currentCol] != null) {
                return false; // Path is blocked
            }
            currentRow += rowStep;
            currentCol += colStep;
        }

        // Check if the destination square is occupied by a piece of the same color
        Piece destinationPiece = board[newPosition.getRow()][newPosition.getCol()];
        if(destinationPiece == null) {
            return true; // Can move to an empty square
        } else if (destinationPiece.getColor() != this.getColor()) {
            return true; // Can capture opponent's piece
        } else {
            return false; // Cannot capture own piece
        }
    }
    
}
