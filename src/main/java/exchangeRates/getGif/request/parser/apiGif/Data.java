package exchangeRates.getGif.request.parser.apiGif;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("embed_url")
    private String embed_url;

    public String getEmbed_url() {
        return embed_url;
    }

    public void setEmbed_url(String embed_url) {
        this.embed_url = embed_url;
    }

}
