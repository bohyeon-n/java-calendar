import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class PromptTest {
    private Prompt prompt;
    private Schedule schedule;

    @Before
    public void before() {
        this.prompt = new Prompt();
        this.schedule = new Schedule();
    }

    @Test(expected = RuntimeException.class)
    public void testValidateDateFormat() {
       ScheduleCommand command =  this.prompt.runMenuPrompt("1");
       String todo = "check date format";
       String date = "2019-1-10";
       String [] args = {date, todo};
       command.input(args, this.schedule);
    }

    private List<String> makeTodo(String todo) {
        List<String> todos = new ArrayList<>();
        todos.add(todo);
        return todos;
    }

    private Map<String, List<String>> makeSchedule(String date, List<String> todos) {
        Map<String, List<String>> schedule = new HashMap<>();
        schedule.put(date, todos);
        return schedule;
    }

    @Test
    public void testAddSchedule() {
        ScheduleCommand command =  this.prompt.runMenuPrompt("1");
        command.commandPrompt();
        String date = "2019-01-01";
        String todo = "study java";
        String[] args = {date, todo};
        List<String> todos = makeTodo(todo);

        Map<String, List<String>> updatedSchedule = command.input(args, this.schedule);
        Map<String, List<String>> expect = makeSchedule(date, todos);
        Assert.assertEquals(updatedSchedule, expect);

        String date2 = "2019-12-23";
        String todo2 = "쉬기";
        String[] args2 = {date2, todo2};
        updatedSchedule = command.input(args2, schedule);
        List<String> todos2 = new ArrayList<>();
        todos2.add(todo2);

        expect.put(date2, todos2);
        Assert.assertEquals(updatedSchedule, expect);
    }

    @Test
    public void testSearchSchedule() {
        String date = "2019-01-01";
        String todo = "study java";
        List<String> todos = new ArrayList<>();
        todos.add(todo);

        ScheduleCommand searchCmd = prompt.runMenuPrompt("2");
        String[] searchArgs = {date};
        Map<String, List<String>> foundSchedule = searchCmd.input(searchArgs, schedule);
        Map<String, List<String>> exptectedSchedule = new HashMap<>();
        exptectedSchedule.put(date, todos );
        Assert.assertEquals(foundSchedule, exptectedSchedule);
    }


}