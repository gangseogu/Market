package com.ticket.market.store.jpa.repository;

import com.ticket.market.store.jpa.jpo.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface MovieRepository extends CrudRepository<Movie, String> {

    List<Movie> findAll();
}
