package exchangeRates.getGif.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import exchangeRates.getGif.request.RequestApiExchangeRate;
import exchangeRates.getGif.request.RequestApiGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.*;

//производит сравнение вчерашнего курса к сегодняшнему и возвращает ссылку на Gif
@Component
public class Compare {

    private RequestApiExchangeRate requestApi;
    private RequestApiGif requestGif;

    @Autowired
    public Compare(RequestApiExchangeRate requestApi, RequestApiGif requestGif) {
        this.requestApi = requestApi;
        this.requestGif = requestGif;
    }


    public String compareCurrency(String codeCurrency) throws JsonProcessingException {
        String gifHost;
        double lastRates = requestApi.rates(codeCurrency, LocalDate.now().minusDays(1).toString());
        double newRates = requestApi.rates(codeCurrency, LocalDate.now().toString());
        if (newRates > lastRates){
            gifHost = requestGif.getGifRich();
        } else {
            gifHost = requestGif.getGifBroke();
        }
        return gifHost;
    }
}
