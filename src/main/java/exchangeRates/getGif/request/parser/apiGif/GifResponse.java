package exchangeRates.getGif.request.parser.apiGif;

import java.util.List;

public class GifResponse {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
