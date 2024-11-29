import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Deque<Player> playerList = new LinkedList<>(); // deque is chosen bcoz when we'll be having mulitple players it would be easy to check whose turn it is
    Dice dice;
    Player winner;

    public Game(){
        initializeGame();
        addPlayers();
    }

    public void initializeGame(){
        winner = null;
        board = new Board(10, 3, 4);
        dice = new Dice(1);
    }

    public void addPlayers(){
        Player player1 = new Player(1,  0);
        Player player2 = new Player(2,  0);
        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame(){
        while(winner == null){
            Player player = findPlayerTurn();
            int rollDice = dice.rollDice();
            int playerPos = player.pos + rollDice;
            playerPos = jumpCheck(playerPos);
            if(playerPos >= board.cells.length * board.cells.length - 1) winner = player;
        }
    }

    private Player findPlayerTurn() {
        Player turnPlayer = playerList.pollFirst();
        playerList.addLast(turnPlayer);
        return turnPlayer;
    }

    public int jumpCheck(int playerNewPos){
        int row = playerNewPos / board.cells.length;
        int col = playerNewPos % board.cells.length;
        if(board.cells[row][col] == null) return playerNewPos;
        Cell cell = board.getCell(playerNewPos);
        if(cell.jump != null && cell.jump.start == playerNewPos){
            return cell.jump.end;
        }
        return playerNewPos;
    }

}
