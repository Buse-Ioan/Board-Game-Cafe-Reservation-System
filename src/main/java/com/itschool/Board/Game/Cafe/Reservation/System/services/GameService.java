package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO createGame(GameDTO gameDTO);

    List<GameDTO> getAllGames();

    GameDTO getGameById(Long id);

    GameDTO updateGame(Long id, GameDTO gameDTO);

    void deleteGameById(Long id);

    List<GameDTO> getGameByName(String name);

    List<GameDTO> getGameByGenre(String genre);
}