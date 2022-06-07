package exchangeRates.getGif.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import exchangeRates.getGif.request.RequestApiExchangeRate;
import exchangeRates.getGif.request.RequestApiGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//производит сравнение вчерашнего курса к сегодняшнему и возвращает ссылку на Gif
@Component
public class Compare {
    private double lastRates;
    private double newRates;

    private RequestApiExchangeRate requestApi;
    private RequestApiGif requestGif;
    private Data day;

    @Autowired
    public Compare(RequestApiExchangeRate requestApi, RequestApiGif requestGif, Data day) {
        this.requestApi = requestApi;
        this.requestGif = requestGif;
        this.day = day;
    }


    public String compareCurrency(String codeCurrency) throws JsonProcessingException {
        String gifHost;
        lastRates = requestApi.rates(codeCurrency, day.getYesterday());
        newRates = requestApi.rates(codeCurrency, day.getToday());
        if (newRates > lastRates){
            gifHost = requestGif.getGifRich();
        } else {
            gifHost = requestGif.getGifBroke();
        }
        lastRates = newRates;
        return gifHost;
    }
}
