Описание.

Данный сервис сравнивает сегодняшний и вчерашний курсы заданной валюты по отношению к USD, и возвращает:

• если сегодняшний курс выше вчерашнего - ссылку на рандомную Gif из https://giphy.com по запросу "rich";

• если сегодняшний курс ниже вчерашнего - ссылку на рандомную Gif из https://giphy.com по запросу "broke".

Инструкция.

Для работы необходимо запустить сервис и перейти на сервер по запросу http://localhost:8080/exchangeRate/gif/{codeCurrency},
где {codeCurrency} - задаваемый 3-х буквенный код валюты, по отношению к которой смотрится курс (например: RUB).

Все параметры вынесены в настроечный файл "application.properties", где необходимо указать свой App ID, для работы с сервисом APi гифок https://developers.giphy.com/docs/api/ и сервисом APi курсов валют https://docs.openexchangerates.org/ .

![image](https://user-images.githubusercontent.com/89867028/172413118-e6d6e1cb-03f8-47d3-b480-40b64129412c.png)
![image](https://user-images.githubusercontent.com/89867028/172414249-ccc895cc-de23-49b2-b72a-7c2a4436164c.png)

Ответом данного сервиса будет ссылка на рандомную Gif.
