package runner.Di;

import org.springframework.stereotype.Component;

@Component
public class CricketBat implements Bat{
    @Override
    public String getBat() {
        return "Take this Reebok Bat";
    }
}
