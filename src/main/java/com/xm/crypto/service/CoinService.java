package com.xm.crypto.service;

import com.xm.crypto.dto.projections.CoinProjection;
import com.xm.crypto.dto.projections.NormalizedCoinProjection;
import com.xm.crypto.repo.CoinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CoinService implements CoinServiceIf {
    @Autowired
    CoinRepository coinRepository;

    @Override
    public CoinProjection oldestNewestMinMaxForSpecificCrypto(String coin) {
        return coinRepository.oldestNewestMinMaxForSpecificCrypto(coin);
    }

    @Override
    public List<CoinProjection> oldestNewestMinMaxForEachCryptoSpecificMonth(int month) {
        return coinRepository.oldestNewestMinMaxForEachCryptoSpecificMonth(month);
    }

    @Override
    public List<NormalizedCoinProjection> descListNormalizedRangeForEachCoin() {
        return coinRepository.descListNormalizedRangeForEachCoin();
    }

    @Override
    public NormalizedCoinProjection highestNormalizedRangeForSpecificDay(Date date) {
        return coinRepository.highestNormalizedRangeForSpecificDay(date);
    }
}
