package exchangeRates.getGif.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
@Scope("prototype")
public class Data {
    private String Today;
    private String Yesterday;

    private SimpleDateFormat simpleDateFormat;
    private Calendar calendar;

    @Autowired
    public Data(SimpleDateFormat simpleDateFormat, Calendar calendar) {
        this.simpleDateFormat = simpleDateFormat;
        this.calendar = calendar;
    }

    public String getToday() {
        Today = simpleDateFormat.format(calendar.getTime()).toString();
        return Today;

    }

    public String getYesterday() {
        calendar.add(Calendar.DAY_OF_MONTH, - 1);
        Yesterday = simpleDateFormat.format(calendar.getTime()).toString();
        return Yesterday;
    }


    public void setToday(String today) {
        Today = today;
    }

    public void setYesterday(String yesterday) {
        Yesterday = yesterday;
    }
}
