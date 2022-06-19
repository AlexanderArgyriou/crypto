package com.xm.crypto.rest;

import com.xm.crypto.dto.projections.CoinProjection;
import com.xm.crypto.dto.projections.NormalizedCoinProjection;
import com.xm.crypto.service.CoinServiceIf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CoinProjection> getInfoForSpecificCoin(@PathVariable String symbol) {
        return new ResponseEntity<>( coinService.oldestNewestMinMaxForSpecificCrypto( symbol ), HttpStatus.OK );
    }

    @GetMapping("/coins/all/{month}")
    public ResponseEntity<List<CoinProjection>> getInfoForEachCryptoSpecificInMonth(@PathVariable int month) {
        return new ResponseEntity<>( coinService.oldestNewestMinMaxForEachCryptoSpecificMonth( month ), HttpStatus.OK );
    }

    @GetMapping("/coins/all/normalized")
    public ResponseEntity<List<NormalizedCoinProjection>> getDescListNormalizedRangeForEachCoin() {
        return new ResponseEntity<>( coinService.descListNormalizedRangeForEachCoin(), HttpStatus.OK );
    }

    @GetMapping("/coins/all/normalized/highest")
    public ResponseEntity<NormalizedCoinProjection> getHighestNormalizedRangeForSpecificDay(@RequestParam("date")
                                                                                            @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return new ResponseEntity<>( coinService.highestNormalizedRangeForSpecificDay( date ), HttpStatus.OK );
    }
}
