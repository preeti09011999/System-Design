
public class ScoreTracker {
    private int[] scores; // Array to hold scores for each frame
    private int currentFrame;
    private int totalScore;

    public ScoreTracker() {
        this.scores = new int[10];
        this.currentFrame = 0;
        this.totalScore = 0;
    }

    public void recordScore(int frame, int pins) {
        if (frame < 1 || frame > 10) {
            throw new IllegalArgumentException("Frame number must be between 1 and 10");
        }
        scores[frame - 1] = pins;
        calculateTotalScore();
    }

    private void calculateTotalScore() {
        totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
    }

    public int getTotalScore() {
        return totalScore;
    }
}
