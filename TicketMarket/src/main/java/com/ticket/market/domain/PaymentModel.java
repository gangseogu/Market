package com.ticket.market.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentModel {

	private String paymentId;
	private String userId;
	private String userName;
	private String reservationId;
	private String ticketId;
	private Integer amtDue;
	private String usedCpId;
	private String usedCpName;
	private Integer cpDisAmt;
	private Integer usedMlg;
	private Integer amtPaid;
	private Integer savedMlg;
	private String paymentDate;
	private String refunded;
	private String refundedDate;
}
