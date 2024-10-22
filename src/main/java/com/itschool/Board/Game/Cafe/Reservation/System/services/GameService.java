package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO saveGame(GameDTO gameDTO);

    List<GameDTO> findAllGames();

    GameDTO findGameById(Long id);

    GameDTO updateGame(Long id, GameDTO gameDTO);

    void deleteGame(Long id);

    List<GameDTO> findByGenre(String genre);
}