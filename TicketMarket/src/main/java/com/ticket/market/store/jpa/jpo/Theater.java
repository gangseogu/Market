package com.ticket.market.store.jpa.jpo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class Theater {

    @Id
    private String TheaName;
    private String TheaLimitRow;
    private String TheaLimitColumn;
    private String TheaBannedSeat;

    public com.ticket.market.domain.Theater toDomain() {
        return new com.ticket.market.domain.Theater(
                this.TheaName,
                this.TheaLimitRow,
                this.TheaLimitColumn,
                this.TheaBannedSeat
        );
    }
}
