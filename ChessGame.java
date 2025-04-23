import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ChessGame {
    private ChessBoard board;
    private boolean isWhiteTurn = true;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public boolean makeMove(Position start, Position end) {
        Piece movingPiece = board.getBoard()[start.getRow()][start.getCol()];
        if (movingPiece == null  || movingPiece.getColor() != (isWhiteTurn ? PieceColor.WHITE : PieceColor.BLACK)) {
            System.out.println("Invalid move. No piece at the starting position or it's not your turn.");
            return false;
        }

        if(movingPiece.isValidMove(end, board.getBoard())) {
            board.movePiece(start, end);
            isWhiteTurn = !isWhiteTurn; // Switch turns
            return true;
        } else {
            System.out.println("Invalid move for the selected piece.");
            return false;
        }
    }

    public boolean isInCheck(PieceColor kingColor) {
        Position kingPosition = findKingPosition(kingColor);
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard().length; col++) {
                Piece piece = board.getBoard()[row][col];
                if (piece != null && piece.getColor() == kingColor) {
                    if(piece.isValidMove(kingPosition, board.getBoard())) {
                        return true; // The king can move to a valid position
                    }
                }
            }
        }
        return false; // No valid moves for the king
    }

    private Position findKingPosition(PieceColor kingColor) {
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard().length; col++) {
                Piece piece = board.getBoard()[row][col];
                if (piece instanceof King && piece.getColor() == kingColor) {
                    return new Position(row, col);
                }
            }
        }
        throw new RuntimeErrorException(null, "King not found on the board.");
    }

    public boolean isCheckmate(PieceColor kingColor) {
        if (!isInCheck(kingColor)) {
            return false; // Not in check, so not checkmate
        }

        Position kingPosition = findKingPosition(kingColor);
        King king = (King) board.getBoard()[kingPosition.getRow()][kingPosition.getCol()];

        for(int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for(int colOffset = -1; colOffset <= 1; colOffset++) {
                if(rowOffset == 0 && colOffset == 0) continue; // Skip the current position
                Position newPosition = new Position(kingPosition.getRow() + rowOffset, kingPosition.getCol() + colOffset);
                if(isPositionOnBoard(newPosition) && king.isValidMove(newPosition, board.getBoard()) && !wouldBeInCheck(kingColor, kingPosition, newPosition)) {
                    return false; // The king can move to a valid position that is not in check
                }
            }
        }
        return true; // No valid moves for the king, so it's checkmate
    }

    private boolean isPositionOnBoard(Position position) {
        return position.getRow() >= 0 && position.getRow() < board.getBoard().length && position.getCol() >= 0 && position.getCol() < board.getBoard()[0].length;
    }

    private boolean wouldBeInCheck(PieceColor kingColor, Position oldPosition, Position newPosition) {
       Piece temp = board.getPiece(newPosition.getRow(), newPosition.getCol());
       board.setPiece(oldPosition, newPosition); // Move the king to the new position
       board.set
    }
}


