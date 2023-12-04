package com.ticket.market.store.jpa;

import com.ticket.market.domain.TheaterModel;
import com.ticket.market.store.jpa.jpo.Movie;
import com.ticket.market.store.jpa.jpo.Theater;
import com.ticket.market.store.jpa.repository.MovieRepository;
import com.ticket.market.store.jpa.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MovieJpaStore implements MovieStore {
    private final MovieRepository movieRepository;


    @Override
    public void save(Movie movieJpo) {
        movieRepository.save(movieJpo);
    }
}
