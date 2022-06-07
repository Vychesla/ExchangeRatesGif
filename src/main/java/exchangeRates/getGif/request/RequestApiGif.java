package exchangeRates.getGif.request;

import exchangeRates.getGif.implementation.Random;
import exchangeRates.getGif.request.parser.apiGif.GifResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//запросы на сервер с картинками GIF
@Component
public class RequestApiGif {
    @Value("${requestApiGif.request}")
    private String request;
    @Value("${requestApiGif.apiId}")
    private String apiId;
    @Value("${requestApiGif.tagRich}")
    private String tagRich;
    @Value("${requestApiGif.tagBroke}")
    private String tagBroke;
    @Value("${requestApiGif.limit}")
    private String limit;
    @Value("${requestApiGif.offset}")
    private String offset;
    @Value("${requestApiGif.span}")
    private int span;

    private String offsetVariable;

    private String hostGifRich;
    private String hostGifBroke;

    private Random random;
    private RestTemplate restTemplate;

    @Autowired
    public RequestApiGif(Random random, RestTemplate restTemplate) {
        this.random = random;
        this.restTemplate = restTemplate;

    }


    public String getGifRich() {
        offsetVariable = Integer.toString(random.getRandomInt(span));
        hostGifRich = request + apiId + tagRich + limit + offset + offsetVariable;
        GifResponse gifResponse = restTemplate.getForObject(hostGifRich, GifResponse.class);
        return gifResponse.getData().get(0).getEmbed_url();
    }


    public String getGifBroke() {
        offsetVariable = Integer.toString(random.getRandomInt(span));
        hostGifBroke = request + apiId + tagBroke + limit + offset + offsetVariable;
        GifResponse gifResponse = restTemplate.getForObject(hostGifBroke, GifResponse.class);
        return gifResponse.getData().get(0).getEmbed_url();
    }

}
