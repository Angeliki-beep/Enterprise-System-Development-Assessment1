package com.example.game.controller;
import com.example.game.model.GameSession;
import com.example.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("currentGame")
public class GameController {
    @Autowired private GameService service;

    @GetMapping("/")
    public String welcome() { return "welcome"; }

    @PostMapping("/start")
    public String start(@RequestParam String name, Model model) {
        model.addAttribute("currentGame", service.createNewGame(name));
        return "redirect:/play";
    }

    @GetMapping("/play")
    public String play() { return "game"; }

    @PostMapping("/guess")
    public String guess(@ModelAttribute("currentGame") GameSession game, @RequestParam int val, Model model) {
        model.addAttribute("feedback", service.processGuess(game, val));
        return "game";
    }
}