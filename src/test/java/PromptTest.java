import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class PromptTest {
    @Test
    public void test() {
        Prompt prompt = new Prompt();
        Schedule schedule = new Schedule();
        prompt.printMenu();
        ScheduleCommand command =  prompt.runMenuPrompt("1");

        command.commandPrompt();

        Map<String, List<String>> expectSchedule = new HashMap<>();

        String date = "2019-01-01";
        String todo = "study java";
        String[] args = {date, todo};
        Map<String, List<String>> updatedSchedule = command.input(args, schedule);
        List<String> todos = new ArrayList<>();
        todos.add(todo);

        expectSchedule.put(date, todos);
        Assert.assertEquals(updatedSchedule, expectSchedule);


        String date2 = "2019-12-23";
        String todo2 = "쉬기";
        String[] args2 = {date2, todo2};
        updatedSchedule = command.input(args2, schedule);
        List<String> todos2 = new ArrayList<>();
        todos2.add(todo2);

        expectSchedule.put(date2, todos2);
        Assert.assertEquals(updatedSchedule, expectSchedule);
    }

}