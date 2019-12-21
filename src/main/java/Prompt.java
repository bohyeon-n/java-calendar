import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {
    private Scanner scanner;
    private Schedule schedule;

    public enum SchedulerCommand {
        ADD,
        SEARCH,
        VIEW_CALENDAR,
        VIEW_HELP,
        QUIT;
    }

    public Prompt() {
        this.scanner = new Scanner(System.in);
        this.schedule = new Schedule();
    }

    public void printMenu() {
        System.out.println("+-------------------------+");
        System.out.println("|  1. 일정 등록             |");
        System.out.println("|  2. 일정 검색             |");
        System.out.println("|  3. 달력 보기             |");
        System.out.println("|  h. 도움말  q.종료         |");
        System.out.println("+--------------------------+");
    }


    public ScheduleCommand runMenuPrompt(String selectedMenu) {
        switch (selectedMenu) {
            case "1":
                return new AddScheduleCommand();
            case "2":
                return new SearchScheduleCommand();
            case "3":
                ;
                break;
            case "h":
                printMenu();
                break;
            case "q":
                System.out.printf("bye ~");
                break;
        }
        // Todo
        return new AddScheduleCommand();
    }



}
