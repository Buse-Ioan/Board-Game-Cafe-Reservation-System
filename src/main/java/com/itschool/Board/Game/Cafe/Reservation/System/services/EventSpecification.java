package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Event;
import org.springframework.data.jpa.domain.Specification;

public class EventSpecification {

    public static Specification<Event> nameContains(String name) {
        return (event, query, criteriaBuilder) -> name == null ? null :
                        criteriaBuilder.like(criteriaBuilder.lower(event.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Event> genreContains(String genre) {
        return (event, query, criteriaBuilder) -> genre == null ? null :
                        criteriaBuilder.like(criteriaBuilder.lower(event.get("gameGenre")), "%" + genre.toLowerCase() + "%");
    }
}