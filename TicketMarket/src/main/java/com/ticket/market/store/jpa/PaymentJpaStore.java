package com.ticket.market.store.jpa;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ticket.market.domain.PaymentModel;
import com.ticket.market.store.jpa.jpo.Payment;
import com.ticket.market.store.jpa.repository.PaymentRepository;

@Repository
@RequiredArgsConstructor
public class PaymentJpaStore implements PaymentStore{
	
	private final PaymentRepository paymentRepository;
	
	@Override
	public List<PaymentModel> findAllByUserId(String userId) {
		return paymentRepository.findAllByUserId(userId).stream()
				.map(Payment::toDomain)
				.collect(Collectors.toList());
	}
}
