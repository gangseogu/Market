package com.ticket.market.store.jpa.jpo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.ticket.market.domain.PaymentModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class Payment {

	@Id
	private String paymentId;
	private String userId;
	private String userName;
	private String reservationId;
	private String ticketId;
	private Integer amtDue;
	@Nullable
	private String usedCpId;
	@Nullable
	private String usedCpName;
	@Nullable
	private Integer cpDisAmt;
	@Nullable
	private Integer usedMlg;
	private Integer amtPaid;
	private Integer savedMlg;
	private String paymentDate;
	private String refunded;
	@Nullable
	private String refundedDate;
	
	public PaymentModel toDomain() {
		return new PaymentModel(
				this.paymentId, 
				this.userId, 
				this.userName, 
				this.reservationId, 
				this.ticketId, 
				this.amtDue, 
				this.usedCpId, 
				this.usedCpName, 
				this.cpDisAmt, 
				this.usedMlg, 
				this.amtPaid, 
				this.savedMlg, 
				this.paymentDate, 
				this.refunded, 
				this.refundedDate
		);
	}
}
