package com.ticket.market.store.jpa;

import com.ticket.market.domain.TheaterModel;
import com.ticket.market.store.jpa.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TheaterJpaStore implements TheaterStore {
    private final TheaterRepository theaterRepository;

    @Override
    public List<TheaterModel> findAllTheater() {
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
    public void update(TheaterModel theaterModel) {
        com.ticket.market.store.jpa.jpo.Theater theaterJpo = theaterRepository.findById(theaterModel.getTheaName()).orElseThrow(() -> new IllegalArgumentException("error"));
    }

    @Override
    public void findById(String title) {
    }


}
