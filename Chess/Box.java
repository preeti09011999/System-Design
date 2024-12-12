package Chess;

public class Box {
    Piece piece;
    Integer x, y;

    public Box(Integer x, Integer y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }
    
}
