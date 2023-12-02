package com.ticket.market.store.jpa;

import com.ticket.market.domain.TheaterModel;
import com.ticket.market.store.jpa.jpo.Theater;

import java.util.List;

public interface TheaterStore {

    List<TheaterModel> findAllTheater();

    void save(Theater TheaterJpo);

    void deleteById(String TheaName);

    void update(TheaterModel theaterModel);

    void findById(String TheaName);
}
