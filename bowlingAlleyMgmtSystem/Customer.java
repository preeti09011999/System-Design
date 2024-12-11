import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    List<Game> gameHistory;

    public Customer(String name, String emailId, String phoneNumber) {
        super(name, emailId, phoneNumber);
        gameHistory = new ArrayList<>();
    }
    void addGameToHistory(Game game) {
        gameHistory.add(game);
    }

    List<Game> getGameHistory(Game game){
        return gameHistory;
    }
}
