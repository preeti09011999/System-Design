/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class Player {
    private String playerId;
    private String name;
    private ScoreTracker scoreTracker;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
        this.scoreTracker = new ScoreTracker();
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public ScoreTracker getScoreTracker() {
        return scoreTracker;
    }
}

