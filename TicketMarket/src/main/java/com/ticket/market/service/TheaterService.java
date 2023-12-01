package com.ticket.market.service;

import com.ticket.market.store.jpa.TheaterStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final TheaterStore theaterStore;
}
