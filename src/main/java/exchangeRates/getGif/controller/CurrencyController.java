package exchangeRates.getGif.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import exchangeRates.getGif.implementation.Compare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// контроллер, в котором происходит логика навигации и обработка запросов
@RestController
@RequestMapping("/exchangeRate")
public class CurrencyController {

    private Compare compare;

    @Autowired
    public CurrencyController(Compare compare) {
        this.compare = compare;
    }

    @GetMapping("/gif/{codeCurrency}")
    public String gifAnswer(@PathVariable("codeCurrency") String codeCurrency) throws JsonProcessingException {
        return compare.compareCurrency(codeCurrency);

    }
}
