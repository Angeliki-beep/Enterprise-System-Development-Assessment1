package com.example.game.service;
import com.example.game.model.GameSession;
import com.example.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {
    @Autowired private GameRepository repository;

    public GameSession createNewGame(String name) {
        GameSession game = new GameSession();
        game.setPlayerName(name);
        game.setTargetNumber(new Random().nextInt(100) + 1);
        game.setAttempts(0);
        game.setFinished(false);
        return repository.save(game);
    }

    public String processGuess(GameSession game, int guess) {
        game.setAttempts(game.getAttempts() + 1);
        if (guess < game.getTargetNumber()) return "Too Low";
        if (guess > game.getTargetNumber()) return "Too High";
        game.setFinished(true);
        repository.save(game);
        return "Correct!";
    }
}