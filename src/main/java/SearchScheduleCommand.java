import java.util.List;
import java.util.Map;

public class SearchScheduleCommand implements ScheduleCommand {
    public String commandPrompt() {
        return null;
    }

    @Override
    public Map<String, List<String>> input(String[] args, Schedule schedule) {
        String date = args[0];
        Map<String, List<String>> schedules =  schedule.searchSchedule(date);
        return schedules;
    }
}
