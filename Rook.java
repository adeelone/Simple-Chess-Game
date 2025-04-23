public class Rook extends Piece {
    public Rook(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        // Rooks can move any number of squares along a row or column
        if(position.getRow() == newPosition.getRow()) {
            // Check if the path is clear horizontally
            int startCol = Math.min(position.getCol(), newPosition.getCol()) + 1;
            int endCol = Math.max(position.getCol(), newPosition.getCol());
            for (int col = startCol; col < endCol; col++) {
                if (board[position.getRow()][col] != null) {
                    return false; // Path is blocked
                }
            }
        } else if(position.getCol() == newPosition.getCol()) {
            // Check if the path is clear vertically
            int startRow = Math.min(position.getRow(), newPosition.getRow()) + 1;
            int endRow = Math.max(position.getRow(), newPosition.getRow());
            for (int row = startRow; row < endRow; row++) {
                if (board[row][position.getCol()] != null) {
                    return false; // Path is blocked
                }
            }
        }   else {
            return false; // Invalid move for a rook
        }
        // Check if the destination square is occupied by a piece of the same color
        Piece destinationPiece = board[newPosition.getRow()][newPosition.getCol()];
        if (destinationPiece == null && destinationPiece.getColor() != this.getColor()) {
            return true; // Cannot capture own piece
        }
        return false; // Invalid move
    }
    
}
