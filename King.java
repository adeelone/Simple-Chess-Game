public class King extends Piece {
    public King(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getCol() - newPosition.getCol());

        // The King moves one square in any direction.
        boolean isOneSquareMove = rowDiff <= 1 && colDiff <= 1 && !(rowDiff == 0 && colDiff == 0);
        if (!isOneSquareMove) {
            return false; // Not a one-square move.
        }

        Piece dest = board[newPosition.getRow()][newPosition.getCol()];
        return (dest == null || dest.getColor() != this.color);
    }
}
