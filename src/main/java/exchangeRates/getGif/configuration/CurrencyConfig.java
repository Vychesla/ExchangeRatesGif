package exchangeRates.getGif.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Configuration
@PropertySource("classpath:application.properties")
public class CurrencyConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return  new SimpleDateFormat("yyyy-MM-dd");
    }

    @Bean
    public Calendar calendar(){
        return Calendar.getInstance();
    }
}
