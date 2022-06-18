package com.xm.crypto.dto.projections;

import java.math.BigDecimal;
import java.util.Date;


public interface CoinProjection {
    String getSymbol();

    Date getMaxTmstp();

    Date getMinTmstp();

    BigDecimal getMaxPrice();

    BigDecimal getMinPrice();
}
