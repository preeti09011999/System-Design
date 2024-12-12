package Chess;

public class Player extends Account{
    private boolean whiteSide;

    public Player(String name, String email) {
        super(name, email);
        this.whiteSide = false;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }
}
