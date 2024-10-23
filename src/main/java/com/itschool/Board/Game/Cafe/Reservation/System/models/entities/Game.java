package com.itschool.Board.Game.Cafe.Reservation.System.models.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "game_name", nullable = false)
    private String name;

    @Column(name = "game_genre", nullable = false)
    private String genre;

    @Column(name = "min_players")
    private int minPlayers;

    @Column(name = "max_players")
    private int maxPlayers;

    @Column(name = "availability", nullable = false)
    private Boolean availability;
}