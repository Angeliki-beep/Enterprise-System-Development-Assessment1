package com.example.game.model;
import jakarta.persistence.*;

@Entity
public class GameSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;
    private int targetNumber;
    private int attempts;
    private boolean isFinished;

    public Long getId() { return id; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String n) { this.playerName = n; }
    public int getTargetNumber() { return targetNumber; }
    public void setTargetNumber(int t) { this.targetNumber = t; }
    public int getAttempts() { return attempts; }
    public void setAttempts(int a) { this.attempts = a; }
    public boolean isFinished() { return isFinished; }
    public void setFinished(boolean f) { this.isFinished = f; }
}