package com.ticket.market.store.jpa;

import com.ticket.market.domain.TheaterModel;
import com.ticket.market.store.jpa.jpo.Movie;
import com.ticket.market.store.jpa.jpo.Theater;

import java.util.List;

public interface MovieStore {

    void save(Movie movieJpo);
}
