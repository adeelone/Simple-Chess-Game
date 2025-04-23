public class Queen extends Piece {
    public Queen(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(newPosition.equals(this.position)) {
            return false; // Invalid move if new position is null
        }
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());

        //Chech for straight line or diagonal move
        boolean straightLineMove = this.position.getRow() == newPosition.getRow() || this.position.getCol() == newPosition.getCol(); // Rook-like move
        boolean diagonalMove = (rowDiff == colDiff); // Bishop-like move
        
        //Calculate direction of movement
        int rowDirection = Integer.compare(newPosition.getRow(), position.getRow());
        int colDirection = Integer.compare(newPosition.getCol(), position.getCol());

        // Check if the path is clear
        int currentRow = position.getRow() + rowDirection;
        int currentCol = position.getCol() + colDirection;
        while (currentRow != newPosition.getRow() || currentCol != newPosition.getCol()) {
            if (board[currentRow][currentCol] != null) {
                return false; // Path is blocked
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }
        // Check if the destination square is occupied by a piece of the same color
        Piece destinationPiece = board[newPosition.getRow()][newPosition.getCol()];
        if (destinationPiece == null) {
            return true; // Can move to an empty square
        } else if (destinationPiece.getColor() != this.getColor()) {
            return true; // Can capture opponent's piece
        } else {
            return false; // Cannot capture own piece
        }
    }
    
}
