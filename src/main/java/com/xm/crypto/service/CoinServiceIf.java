package com.xm.crypto.service;

import com.xm.crypto.dto.projections.CoinProjection;
import com.xm.crypto.dto.projections.NormalizedCoinProjection;

import java.util.Date;
import java.util.List;

public interface CoinServiceIf {
    CoinProjection oldestNewestMinMaxForSpecificCrypto(String coin);

    List<CoinProjection> oldestNewestMinMaxForEachCryptoSpecificMonth(int month);

    List<NormalizedCoinProjection> descListNormalizedRangeForEachCoin();

    NormalizedCoinProjection highestNormalizedRangeForSpecificDay(Date date);
}
