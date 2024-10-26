package com.itschool.Board.Game.Cafe.Reservation.System.controllers;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.GameDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Create a new game")
    @PostMapping
    public ResponseEntity<GameDTO> createGame(@Valid @RequestBody GameDTO gameDTO) {
        return ResponseEntity.ok(gameService.createGame(gameDTO));
    }

    @Operation(summary = "Get a list of all games")
    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @Operation(summary = "Get a game by ID")
    @GetMapping("/id/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @Operation(summary = "Get a game by name")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<GameDTO>> getGameByName(@PathVariable String name) {
        return ResponseEntity.ok(gameService.getGameByName(name));
    }

    @Operation(summary = "Get a game by genre")
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<GameDTO>> getGameByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(gameService.getGameByGenre(genre));
    }

    @Operation(summary = "Update an existing game by ID")
    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody GameDTO gameDTO) {
        return ResponseEntity.ok(gameService.updateGame(id, gameDTO));
    }

    @Operation(summary = "Delete a game by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable Long id) {
        gameService.deleteGameById(id);
        return ResponseEntity.noContent().build();
    }
}