package Chess;

import java.util.*;

public class GameHandler {
    
    private final Queue<Player> playerQueue;
    private final Board board;
    private final GameStatus gameStatus;
    private final List<Move> moveList;
    
    public GameHandler(){
        this.playerQueue = new LinkedList<>();
        this.board = board;
        this.gameStatus = GameStatus.START;
        this.moveList = new ArrayList<>();
    }

    public void initializeGame(Player p1, Player p2) {
        if(p1.isWhiteSide()){
            playerQueue.add(p1);
            playerQueue.add(p2);
        }
        else{
            playerQueue.add(p2);
            playerQueue.add(p1);
        }
    }

    public boolean movePiece(int startx, int starty, int endx, int endy) {
        Player curPlayer = playerQueue.poll();
        Box startBox = board.getBox(startx, starty);
        Box endBox = board.getBox(endx, endy);
        Move move = new Move(curPlayer, startBox, endBox);
        return makeMove(curPlayer, move);
    }

    private boolean makeMove(Player currentPlayer, Move move) {
        Box startBox = move.getStart();
        Box endBox = move.getEnd();
        if (startBox == null || (currentPlayer.isWhiteSide() != startBox.getPiece().isWhitePiece())) {
            return false;
        }
        if (!startBox.getPiece().canMove(board, startBox, endBox)) {
            return false;
        }
        if (endBox != null) {
            endBox.getPiece().setKilled(true);
            move.setPieceKilled(endBox.getPiece());
        }
        // store the move
        moveList.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);
        return true;
    }
}
