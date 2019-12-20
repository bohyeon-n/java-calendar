import java.util.List;
import java.util.Map;

public class AddScheduleCommand implements ScheduleCommand {
    @Override
    public String commandPrompt() {
        return null;
    }

    @Override
    public Map<String, List<String>> input(String[] args, Schedule schedule) {
        Map<String, List<String>> newSchedule =  schedule.addSchedule(args[0], args[1]);
        return newSchedule;
    }
}
