import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();

        // Create players
        Player alice = new Player("P001", "Alice");
        Player bob = new Player("P002", "Bob");
        List<Player> players = List.of(alice, bob);

        // Start a game
        String gameId = gameHandler.startNewGame("Game001", players);

        // Record scores
        gameHandler.recordPlayerScore(gameId, "P001", 1, 9); // Alice scores 9 in frame 1
        gameHandler.recordPlayerScore(gameId, "P002", 1, 8); // Bob scores 8 in frame 1

        // End the game
        gameHandler.endGame(gameId);
    }
}
