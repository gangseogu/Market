package com.ticket.market.store.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.market.store.jpa.jpo.Payment;

@Transactional(readOnly = true)
public interface PaymentRepository extends CrudRepository<Payment, String> {

	List<Payment> findAllByUserIdAndPaymentDateBetween(String userId, LocalDate startDate, LocalDate endDate);
	
}
