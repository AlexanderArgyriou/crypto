package com.xm.crypto.repo;

import com.xm.crypto.domain.Coin;
import com.xm.crypto.dto.projections.CoinProjection;
import com.xm.crypto.dto.projections.NormalizedCoinProjection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CoinRepository extends CrudRepository<Coin, Long> {
    /*
        return the oldest/newest/min/max values for a requested crypto
     */
    @Query(value = "select symbol, max(tmstp) as maxTmstp, min(tmstp) as minTmstp, " +
            "max(price) as maxPrice, min(price) as minPrice " +
            "from Coin where symbol = :symbol", nativeQuery = true)
    CoinProjection oldestNewestMinMaxForSpecificCrypto(@Param("symbol") String coin);

    /*
        Calculates oldest/newest/min/max for each crypto for the whole month
     */
    @Query(value = "select symbol, max(tmstp) as maxTmstp, min(tmstp) as minTmstp, " +
            "max(price) as maxPrice, min(price) as minPrice " +
            "from Coin where extract(month from tmstp) = :month " +
            "group by symbol", nativeQuery = true)
    List<CoinProjection> oldestNewestMinMaxForEachCryptoSpecificMonth(@Param("month") int month);

    /*
        return a descending sorted list of all the cryptos,
        comparing the normalized range (i.e. (max-min)/min)
     */
    @Query(value = "select symbol, CAST((max(price) - min(price)) / min(price) as decimal(20, 2)) as norm " +
            "from coin " +
            "group by symbol " +
            "order by norm desc", nativeQuery = true)
    List<NormalizedCoinProjection> descListNormalizedRangeForEachCoin();

    /*
        Exposes an endpoint that will return the crypto with the highest normalized range for a
        specific day
     */
    @Query(value = "with normalized_table(symbol, norm_value) as " +
            "(select coin.symbol, cast((max(coin.price) - min(coin.price)) / min(coin.price) as decimal(20, 2)) as norm " +
            "from coin where day_of_year(coin.tmstp) = day_of_year(:date) " +
            "group by coin.symbol) " +
            "select normalized_table.symbol as symbol, normalized_table.norm_value as norm from normalized_table " +
            "where normalized_table.norm_value in (select max(normalized_table.norm_value) from normalized_table)", nativeQuery = true)
    NormalizedCoinProjection highestNormalizedRangeForSpecificDay(@Param("date") Date date);


}

