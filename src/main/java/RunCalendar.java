import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
public class RunCalendar {
    private Scanner scanner;
    private Schedule schedule;
    private static final String SAVE_FILE = "calendar.dat";

    public RunCalendar() {
        this.scanner = new Scanner(System.in);
        this.schedule = new Schedule();
        File f=  new File(SAVE_FILE);
        if(!f.exists()) {
            return;
        }
        try {
            Scanner s = new Scanner(f);
            String fileString =  s.toString();
            System.out.println(fileString);
            while(s.hasNextLine()) {
                String line = s.nextLine();
                String [] splitline = line.split(",");
                this.schedule.initSchedule(splitline[0] , splitline[1]);
            }
            s.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }


    public void addSchedule(ScheduleCommand cmd) {
        System.out.println("[일정 등록] 날짜를 입력하세요.");
        System.out.printf("> ");
        System.out.println();
        String date = this.scanner.nextLine();
        System.out.println("[일정 등록] 일정을 입력하세요.");
        System.out.println("> ");
        String todo = this.scanner.nextLine();
        String[] args = {date, todo};
        cmd.input(args, this.schedule);
    }

    public void searchSchedule(ScheduleCommand cmd) {
        System.out.println(this.schedule);
        System.out.println("검색 날짜를 입력하세요 예) yyyy-mm-dd");
        System.out.printf("DATE> ");
        String date = this.scanner.nextLine().trim();
        String[] args = {date};
        Map<String, List<String>> res = cmd.input(args, schedule);
        List<String> todos = res.get(date);
        System.out.println(todos);
        if (!todos.isEmpty()) {
            System.out.println(todos
                    .size() + "개의 일정이 있습니다.");
            todos.forEach((s) -> System.out.println(s));


        } else {
            System.out.println("일정이 없습니다.");
        }
    }

    public void printCalendar() {
        Calendar cal = new Calendar();

        System.out.println("년을 입력하세요. (exit: -1)");
        System.out.println("YEAR> ");
        int year = this.scanner.nextInt();
        if (year == -1) {
            return;
        }
        System.out.println("MONTH> ");
        int month = this.scanner.nextInt();

        System.out.println(month);
        System.out.println(year);
        if (month > 12 || month < 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        cal.printCalendar(year, month, this.schedule);
    }

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        RunCalendar cal = new RunCalendar();
        Scanner scanner = new Scanner(System.in);
        prompt.printMenu();
        boolean isClose = false;
        while (!isClose) {
            System.out.println("Menu>");
            String menu = scanner.nextLine().trim();
            ScheduleCommand cmd = prompt.runMenuPrompt(menu);

            switch (menu) {
                case "q":
                    isClose = true;
                    break;
                case "1":
                    cal.addSchedule(cmd);
                    break;
                case "2":
                    cal.searchSchedule(cmd);
                    break;
                case "3":
                    cal.printCalendar();
                    break;
            }
        }
    }


}
