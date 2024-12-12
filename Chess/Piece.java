package Chess;

public abstract class Piece {
    PieceType pieceType;
    boolean killed;

    public Piece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public boolean isWhitePiece() {
        return getPieceType().equals(PieceType.WHITE);
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Box start, Box end);    
}
