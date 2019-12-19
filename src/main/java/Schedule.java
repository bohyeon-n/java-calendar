import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {

    Map<String, List<String>> schedules = new HashMap<>();

    public Map<String, List<String>> addSchedule(String date, String todo) {
        if(this.schedules.containsKey(date)) {
           List<String> todoList =  this.schedules.get(date);
           todoList.add(todo);
        }else {
            List<String> todoList = new ArrayList<>();
            todoList.add(todo);
            this.schedules.put(date, todoList);
        }
        System.out.println(schedules);
        return this.schedules;
    }

    public List<String> searchSchedule(String date) {
        return this.schedules.get(date);
    }

    public boolean existSchedules(String date) {
        return this.schedules.containsKey(date);
    }
}
