package com.xm.crypto.rest;

import com.xm.crypto.dto.projections.CoinProjection;
import com.xm.crypto.dto.projections.NormalizedCoinProjection;
import com.xm.crypto.service.CoinServiceIf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/crypto/info", produces = "application/json")
public class CryptoRestController {
    @Autowired
    CoinServiceIf coinService;

    @GetMapping("/coin/{symbol}")
    public CoinProjection getInfoForSpecificCoin(@PathVariable String symbol) {
        return coinService.oldestNewestMinMaxForSpecificCrypto(symbol);
    }

    @GetMapping("/coins/all/{month}")
    public List<CoinProjection> getInfoForEachCryptoSpecificInMonth(@PathVariable int month) {
        return coinService.oldestNewestMinMaxForEachCryptoSpecificMonth(month);
    }

    @GetMapping("/coins/all/normalized")
    public List<NormalizedCoinProjection> getDescListNormalizedRangeForEachCoin() {
        return coinService.descListNormalizedRangeForEachCoin();
    }

    @GetMapping("/coins/all/normalized/highest")
    public NormalizedCoinProjection getHighestNormalizedRangeForSpecificDay(@RequestParam("date")
                                                                            @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return coinService.highestNormalizedRangeForSpecificDay(date);
    }
}
