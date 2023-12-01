package com.ticket.market.store.jpa;

import com.ticket.market.store.jpa.jpo.Theater;

import java.util.List;
import java.util.Optional;

public interface TheaterStore {

    List<com.ticket.market.domain.Theater> findAllTheater();

    void save(Theater TheaterJpo);

    void deleteById(String TheaName);

    void update(com.ticket.market.domain.Theater theater);

    void findById(String TheaName);
}
