package com.example.game.repository;
import com.example.game.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameSession, Long> { }