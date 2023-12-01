package com.ticket.market.store.jpa.repository;

import com.ticket.market.store.jpa.jpo.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface TheaterRepository extends CrudRepository<Theater, String> {

    List<Theater> findAll();
}
