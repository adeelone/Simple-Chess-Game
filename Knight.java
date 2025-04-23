public class Knight extends Piece {
    public Knight(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(newPosition.equals(this.position)) {
            return false; // Invalid move if new position is null
        }
        int rowDiff = Math.abs(newPosition.getRow() - position.getRow());
        int colDiff = Math.abs(newPosition.getCol() - position.getCol());

        // Knights move in an "L" shape: two squares in one direction and one square perpendicular
        boolean isValidMove = (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
        if (!isValidMove) {
            return false; // Invalid move for a knight
        }
        // Check if the destination square is occupied by a piece of the same color
        Piece tarPiece = board[newPosition.getRow()][newPosition.getCol()];
        if (tarPiece == null && tarPiece.getColor() != this.getColor()) {
            return true; // Can capture own piece
        }else{
            return tarPiece.getColor() != this.getColor(); // Cannot capture own piece
        }
    }
    
}
