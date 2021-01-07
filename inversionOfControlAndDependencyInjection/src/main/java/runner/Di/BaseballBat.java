package runner.Di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("thebatIuseLess")
public class BaseballBat {//implements Bat{

    public String getBat() {
        return "Take this big baseball bat";
    }
}
