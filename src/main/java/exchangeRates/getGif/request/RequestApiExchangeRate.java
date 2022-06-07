package exchangeRates.getGif.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import exchangeRates.getGif.request.parser.apiExchangeRate.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


//запросы на сервер с API сервисом валют
@Component
public class RequestApiExchangeRate {
    @Value("${requestApiExchangeRate.request}")
    private String request;
    @Value("${requestApiExchangeRate.data}")
    private String data;
    @Value("${requestApiExchangeRate.apiId}")
    private String apiId;
    @Value("${requestApiExchangeRate.symbols}")
    private String symbols;

    private String url;

    private RestTemplate restTemplate;

    @Autowired
    public RequestApiExchangeRate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double rates (String codeCurrency, String day) throws JsonProcessingException {
        url = request + day + data + apiId  + symbols + codeCurrency;
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
        return response.getRates().get(codeCurrency);
    }
}
