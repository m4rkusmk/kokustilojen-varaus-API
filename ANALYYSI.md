## 1. Mitä tekoäly teki hyvin?
Tekoäly teki projektin rakenteen hyvin ja helposti hallittavaksi. Tietokantaoperaatiot löytyvät Repository-luokista 
ja tarkempi toimintalogiikka Service-luokista.

## 2. Mitä tekoäly teki huonosti?
Tekoälyn tuottamassa koodissa puuttui tietoa käyttäjän yksilöimiseen. Lisäksi kokoustiloja ja käyttäjiä olisi voinut
lisätä useita samoille nimille, mikä ei ole toivottava ominaisuus.

## 3. Mitkä olivat tärkeimmät parannukset, jotka teit tekoälyn tuottamaan koodiin ja miksi?
Lisäsin käyttäjän yksilöimisen minimitiedoksi kentän sähköpostiosoitteelle ja estin käyttäjän lisäämisen 
mikäli järjestelmässä on jo käyttäjärivi samalla sähköpostiosoitteella.
Muokkasin kokoustilojen lisäämisen logiikkaa siten, ettei nimettömiä tai samannimisiä kokoustiloja voi lisätä.
On järjestelmän luotettavuuden kannalta äärimmäisen tärkeää, että järjestelmästä löytyy tasan niin monta
käyttäjää ja kokoustilaa kuin fyysisestikin on olemassa.
