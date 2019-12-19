import java.util.List;
import java.util.Map;

public interface ScheduleCommand {
    public String commandPrompt();
    Map<String, List<String>> input(String [] args, Schedule schedule);
}
