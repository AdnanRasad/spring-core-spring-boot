package runner.bestCoach;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("myCricketCoach")
public class CricketBestCoach implements BestCoach {

    @Override
    public String getDailyWorkout() {
        return "bat for 30 min";
    }
}
