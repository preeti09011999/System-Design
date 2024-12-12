package Chess;

public class Board {
    Box[][] chessBoard;
    Integer boardSize;

    public Board() {
        this.boardSize = 8;
        this.resetBoard();
    }

    public void resetBoard() {
        this.chessBoard = new Box[boardSize][boardSize];
        chessBoard[0][0] = new Box(0, 0, new Rook(PieceType.WHITE));
        chessBoard[0][1] = new Box(0, 1, new Knight(PieceType.WHITE));
        chessBoard[0][2] = new Box(0, 2, new Bishop(PieceType.WHITE));
        chessBoard[0][3] = new Box(0, 3, new Queen(PieceType.WHITE));
        chessBoard[0][4] = new Box(0, 4, new King(PieceType.WHITE));
        chessBoard[0][5] = new Box(0, 5, new Bishop(PieceType.WHITE));
        chessBoard[0][6] = new Box(0, 6, new Knight(PieceType.WHITE));
        chessBoard[0][7] = new Box(0, 7, new Rook(PieceType.WHITE));

        for (int i = 0; i < this.boardSize; i++) {
            chessBoard[1][i] = new Box(1, i, new Pawn(PieceType.WHITE));
        }


        chessBoard[7][0] = new Box(7, 0, new Rook(PieceType.BLACK));
        chessBoard[7][1] = new Box(7, 1, new Knight(PieceType.BLACK));
        chessBoard[7][2] = new Box(7, 2, new Bishop(PieceType.BLACK));
        chessBoard[7][3] = new Box(7, 3, new Queen(PieceType.BLACK));
        chessBoard[7][4] = new Box(7, 4, new King(PieceType.BLACK));
        chessBoard[7][5] = new Box(7, 5, new Bishop(PieceType.BLACK));
        chessBoard[7][6] = new Box(7, 6, new Knight(PieceType.BLACK));
        chessBoard[7][7] = new Box(7, 7, new Rook(PieceType.BLACK));

        for (int i = 0; i < this.boardSize; i++) {
            chessBoard[6][i] = new Box(6, i, new Pawn(PieceType.BLACK));
        }
    }

    private void addPieceToBox(Box box, Integer x, Integer y) {
        chessBoard[x][y] = box;
    }

    private void removePieceFromBox(Integer x, Integer y) {
        chessBoard[x][y] = null;
    }

    public Box getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return chessBoard[x][y];
    }
}
