package com.ticket.market.store.jpa;

import com.ticket.market.domain.Theater;
import com.ticket.market.store.jpa.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TheaterJpaStore implements TheaterStore {
    private final TheaterRepository theaterRepository;

    @Override
    public List<Theater> findAllTheater() {
        return theaterRepository.findAll().stream()
                .map(com.ticket.market.store.jpa.jpo.Theater::toDomain)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public void save(com.ticket.market.store.jpa.jpo.Theater theaterJpo) {
        theaterRepository.save(theaterJpo);
    }

    @Override
    public void deleteById(String TheaName) {
        theaterRepository.deleteById(TheaName);
    }

    @Override
    public void update(Theater theater) {
        com.ticket.market.store.jpa.jpo.Theater theaterJpo = theaterRepository.findById(theater.getTheaName()).orElseThrow(() -> new IllegalArgumentException("error"));
    }

    @Override
    public void findById(String title) {
    }


}
