package com.ticket.market.store.jpa;

import java.util.List;

import com.ticket.market.domain.PaymentModel;

public interface PaymentStore {
	
	List<PaymentModel> findAllByUserId(String userId);
	
}
