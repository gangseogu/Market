package com.ticket.market.store.jpa;

import java.time.LocalDate;
import java.util.List;

import com.ticket.market.domain.PaymentModel;

public interface PaymentStore {
	
	List<PaymentModel> findAllByUserIdAndPaymentDateBetween(String userId, LocalDate startDate, LocalDate endDate);
	
}
