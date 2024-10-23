package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO createGame(GameDTO gameDTO);

    List<GameDTO> findAllGames();

    GameDTO findGameById(Long id);

    GameDTO updateGame(Long id, GameDTO gameDTO);

    void deleteGameById(Long id);

    List<GameDTO> findGameByName(String name);

    List<GameDTO> findByGenre(String genre);
}