package com.ticket.market.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.market.domain.PaymentModel;
import com.ticket.market.store.jpa.PaymentStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentStore paymentStore;
	
	@Transactional
	public List<PaymentModel> findAllByUserIdAndPaymentDateBetween(String userId, LocalDate startDate, LocalDate endDate) {
		return paymentStore.findAllByUserIdAndPaymentDateBetween(userId, startDate, endDate);
	}
}
