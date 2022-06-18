-- temp views to load data.
-- cast to date the epochs immediately to avoid further java complexity
-- this could be a procedure applied to the whole folder in a production db.
-- obvious reasons to use an in memory for dummy examples

WITH BTC(tmstp, symbol, price)
AS (SELECT timestamp, symbol, price FROM CSVREAD('src/main/resources/data/BTC_values.csv'))
INSERT INTO COIN (tmstp, symbol, price) SELECT DATEADD('MILLISECOND', tmstp, DATE '1970-01-01'), symbol, price FROM BTC;

WITH DOGE(tmstp, symbol, price)
AS (SELECT timestamp, symbol, price FROM CSVREAD('src/main/resources/data/DOGE_values.csv'))
INSERT INTO COIN (tmstp, symbol, price) SELECT DATEADD('MILLISECOND', tmstp, DATE '1970-01-01'), symbol, price FROM DOGE;

WITH ETH(tmstp, symbol, price)
AS (SELECT timestamp, symbol, price FROM CSVREAD('src/main/resources/data/ETH_values.csv'))
INSERT INTO COIN (tmstp, symbol, price) SELECT DATEADD('MILLISECOND', tmstp, DATE '1970-01-01'), symbol, price FROM ETH;

WITH LTC(tmstp, symbol, price)
AS (SELECT timestamp, symbol, price FROM CSVREAD('src/main/resources/data/LTC_values.csv'))
INSERT INTO COIN (tmstp, symbol, price) SELECT DATEADD('MILLISECOND', tmstp, DATE '1970-01-01'), symbol, price FROM LTC;

WITH XRP(tmstp, symbol, price)
AS (SELECT timestamp, symbol, price FROM CSVREAD('src/main/resources/data/XRP_values.csv'))
INSERT INTO COIN (tmstp, symbol, price) SELECT DATEADD('MILLISECOND', tmstp, DATE '1970-01-01'), symbol, price FROM XRP;