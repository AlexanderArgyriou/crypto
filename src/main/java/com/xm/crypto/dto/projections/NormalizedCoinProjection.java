package com.xm.crypto.dto.projections;

import java.math.BigDecimal;

public interface NormalizedCoinProjection {
    String getSymbol();

    BigDecimal getNorm();
}
