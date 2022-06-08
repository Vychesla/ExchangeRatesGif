package exchangeRates.getGif.implementation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Random {
    private int randomInt;

    public int getRandomInt(int span){
        randomInt = (int)(Math.random() * span);
        return randomInt;
    }


}
