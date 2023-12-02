package com.ticket.market.store.jpa.jpo;

import com.ticket.market.domain.TheaterModel;
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

    public TheaterModel toDomain() {
        return new TheaterModel(
                this.TheaName,
                this.TheaLimitRow,
                this.TheaLimitColumn,
                this.TheaBannedSeat
        );
    }
}
