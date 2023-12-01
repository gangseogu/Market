package com.ticket.market.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Theater {

    private String TheaName;
    private String TheaLimitRow;
    private String TheaLimitColumn;
    private String TheaBannedSeat;
}
