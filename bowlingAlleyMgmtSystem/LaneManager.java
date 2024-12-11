import java.util.ArrayList;
import java.util.List;

public class LaneManager {
    private static LaneManager instance;
    private List<Lane> lanes;

    private LaneManager() {
        this.lanes = new ArrayList<>();
        // Initialize lanes (e.g., 10 lanes)
        for (int i = 1; i <= 10; i++) {
            lanes.add(new Lane(i));
        }
    }

    public static LaneManager getInstance() {
        if (instance == null) {
            instance = new LaneManager();
        }
        return instance;
    }

    public Lane assignAvailableLane() {
        for (Lane lane : lanes) {
            if (!lane.isAvailable()) {
                lane.setAvailable(true);
                return lane;
            }
        }
        return null; // No lanes available
    }

    public void releaseLane(Lane lane) {
        lane.setAvailable(false);
    }
}
