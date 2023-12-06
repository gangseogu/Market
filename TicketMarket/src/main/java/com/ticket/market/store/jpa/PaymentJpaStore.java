package com.ticket.market.store.jpa;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
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
	public List<PaymentModel> findAllByUserIdAndPaymentDateBetween(String userId, LocalDate startDate, LocalDate endDate) {
		return paymentRepository.findAllByUserIdAndPaymentDateBetween(userId, startDate, endDate).stream()
				.map(Payment::toDomain)
				.sorted(Comparator.comparing(PaymentModel::getPaymentId).reversed())
				.collect(Collectors.toList());
	}
}
