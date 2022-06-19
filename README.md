# crypto

Sample project

- this projects aim to provide a crypto api

- we use hibernate alongside spring data jpa config to load csv files from resources to an in memory h2 DB.

- we provide a variety of endopoints while working with an extended crud repo in order to handle requests on crypto data

- sample end point: http://localhost:8080/api/crypto/info/coin/BTC

- we also use bucke4j and java cache api in order to provide limit access to endpoints base on api.

- that's all more or else, just run **mvn clean install -Dmaven.test.skip=true -f pom.xml** then **mvn spring-boot:run -Dmaven.test.skip=true -f pom.xml**

- enjoy :)
