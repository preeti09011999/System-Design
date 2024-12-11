/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

class Game {
    private String gameId;
    private Lane lane;
    private List<Player> players;
    private boolean isOngoing;
    private int currentTurn;

    public Game(String gameId, Lane lane) {
        this.gameId = gameId;
        this.lane = lane;
        this.players = new ArrayList<>();
        this.isOngoing = true;
        this.currentTurn = 0; // Start with the first player
    }

    public void addPlayer(Player player) {
        if (isOngoing) {
            players.add(player);
        } else {
            throw new IllegalStateException("Cannot add players to a completed game.");
        }
    }

    public void recordScore(String playerId, int frame, int pins) {
        if (!isOngoing) {
            throw new IllegalStateException("Cannot record scores for a completed game.");
        }

        Player player = players.stream()
                .filter(p -> p.getPlayerId().equals(playerId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        player.getScoreTracker().recordScore(frame, pins);
        nextTurn();
    }

    private void nextTurn() {
        currentTurn = (currentTurn + 1) % players.size(); // Rotate to the next player
    }

    public void endGame() {
        this.isOngoing = false;
        System.out.println("Game ended. Final scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScoreTracker().getTotalScore());
        }
    }

    public Lane getLane() {
        return lane;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isOngoing() {
        return isOngoing;
    }

    public Player getCurrentPlayer() {
        return players.get(currentTurn);
    }
}
