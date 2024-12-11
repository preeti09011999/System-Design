import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHandler {
    private Map<String, Game> activeGames; // Active games mapped by Game ID
    private LaneManager laneManager;      // Singleton for managing lanes

    public GameHandler() {
        this.activeGames = new HashMap<>();
        this.laneManager = LaneManager.getInstance(); // Singleton instance for lane management
    }

    // Start a new game
    public String startNewGame(String gameId, List<Player> players) {
        Lane lane = laneManager.assignAvailableLane();
        if (lane == null) {
            throw new IllegalStateException("No lanes available!");
        }

        Game game = new Game(gameId, lane);
        for (Player player : players) {
            game.addPlayer(player);
        }

        activeGames.put(gameId, game);
        System.out.println("Game started with ID: " + gameId + " on Lane " + lane.getLaneId());
        return gameId;
    }

    // End an existing game
    public void endGame(String gameId) {
        Game game = activeGames.get(gameId);
        if (game == null) {
            throw new IllegalArgumentException("Game not found with ID: " + gameId);
        }

        game.endGame();
        laneManager.releaseLane(game.getLane()); // Free the lane
        activeGames.remove(gameId);
        System.out.println("Game with ID: " + gameId + " has ended.");
    }

    // Record a score for a player
    public void recordPlayerScore(String gameId, String playerId, int frame, int pins) {
        Game game = activeGames.get(gameId);
        if (game == null) {
            throw new IllegalArgumentException("Game not found with ID: " + gameId);
        }

        game.recordScore(playerId, frame, pins);
    }

    // Get details of an active game
    public Game getGameDetails(String gameId) {
        return activeGames.get(gameId);
    }

    // List all active games
    public Map<String, Game> getActiveGames() {
        return activeGames;
    }
}
