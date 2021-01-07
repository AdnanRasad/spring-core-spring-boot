package runner.bestCoach;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("myBaseballCoach")
public class BaseballBestCoach implements BestCoach {

    @Override
    public String getDailyWorkout() {
        return "run for 30 min";
    }
}
