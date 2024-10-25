package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.exceptions.GameNotFoundException;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.GameDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Game;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);
    private final ObjectMapper objectMapper;
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(ObjectMapper objectMapper, GameRepository gameRepository) {
        this.objectMapper = objectMapper;
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDTO createGame(GameDTO gameDTO) {
        // Using ObjectMapper to map DTO to entity
        Game game = objectMapper.convertValue(gameDTO, Game.class);
        Game createdGame = gameRepository.save(game);
        log.info("Game saved successfully with ID: {}", createdGame.getId());

        return objectMapper.convertValue(createdGame, GameDTO.class);
    }

    @Override
    public List<GameDTO> findAllGames() {
        List<Game> games = gameRepository.findAll();
        log.info("Found {} games", games.size());

        return games.stream()
                .map(game -> objectMapper.convertValue(game, GameDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GameDTO findGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Game not found with ID: " + id));
        log.info("Game found: {}", game.getName());

        return objectMapper.convertValue(game, GameDTO.class);

    }



    @Override
    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Game not found with ID: " + id));

        existingGame.setName(gameDTO.getName());
        existingGame.setGenre(gameDTO.getGenre());
        existingGame.setMinPlayers(gameDTO.getMinPlayers());
        existingGame.setMaxPlayers(gameDTO.getMaxPlayers());
        Game updatedGame = gameRepository.save(existingGame);
        log.info("Game updated successfully: {}", updatedGame.getName());

        return objectMapper.convertValue(updatedGame, GameDTO.class);
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Game not found with ID: " + id));

        gameRepository.deleteById(id);
        log.info("Game deleted successfully");
    }

    @Override
    public List<GameDTO> findByGenre(String genre) {
        List<Game> games = gameRepository.findByGenre(genre);
        log.info("Found {} games with genre: {}", games.size(), genre);

        return games.stream()
                .map(game -> objectMapper.convertValue(game, GameDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameDTO> findGameByName(String name) {
        List<Game> games = gameRepository.findByNameContainingIgnoreCase(name);
        log.info("Found {} games with name: {}", games.size(), name);

        return games.stream()
                .map(game -> objectMapper.convertValue(game, GameDTO.class))
                .collect(Collectors.toList());
    }
}