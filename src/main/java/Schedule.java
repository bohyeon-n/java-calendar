import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Schedule {
    private Map<String, List<String>> schedules;
    private static final String SAVE_FILE = "calendar.dat";
    public Schedule() {
        this.schedules  = new HashMap<>();

    }

    public static void main(String[] args) {
        Schedule s = new Schedule();
        s.addSchedule("2019-01-01", "study english");
        s.addSchedule("2019-12-23", "birthday");
    }

    public Map<String, List<String>> addSchedule(String date, String todo) {
        if(!isValidDateFormat(date)) {
            throw new RuntimeException("날자 포맷이 맞지 않습니다.");
        }
        addScheduleData(date, todo);
        addScheduleFileData(date, todo);
        return this.schedules;
    }

    public void addScheduleFileData(String date, String todo) {
        String scheduleStr = date + "," + todo  + "\n";
        try {
            FileWriter fw = new FileWriter(SAVE_FILE, true);
            fw.write(scheduleStr);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(schedules);
    }


    public void addScheduleData(String date, String todo ) {
        if(this.schedules.containsKey(date)) {
            List<String> todoList =  this.schedules.get(date);
            todoList.add(todo);
        }else {
            List<String> todoList = new ArrayList<>();
            todoList.add(todo);
            this.schedules.put(date, todoList);
        }
    }

    public void initSchedule(String date, String todo) {
       addScheduleData(date, todo);
    }

    public Map<String, List<String>> searchSchedule(String date) {
        List<String> todoList = this.schedules.get(date);
        Map<String, List<String>> schedule = new HashMap<>();
        schedule.put(date, todoList);
        return schedule;
    }

    public boolean existSchedules(String date) {
        return this.schedules.containsKey(date);
    }

    private boolean isValidDateFormat(String date) {
        String[] splitDate = date.split("-");
        if (splitDate.length != 3) {
            return false;
        }
        if(splitDate[0].length() != 4  || splitDate[1].length() != 2 || splitDate[2].length() != 2) {
            return false;
        }

        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        boolean isValidYear = splitDate[0].length() == 4 && year >= 1970;
        boolean isValidMonth = month > 0 && month <= 12;
        boolean isValidDay = day > 0 && day <= 31;
        return isValidYear && isValidMonth && isValidDay;
    }

}
