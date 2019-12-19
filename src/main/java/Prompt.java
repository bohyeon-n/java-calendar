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
        System.out.println("명령 (1, 2, 3, h, q)");
        switch (selectedMenu) {
            case "1":
                return new AddScheduleCommand();
            case "2":

            case "3":
                runCalendarPrompt();
                break;
            case "h":
                printHelp();
                break;
            case "q":
                break;
        }
        // bye
        return new AddScheduleCommand();
    }

    public void printHelp() {
        System.out.println("도움말!!");
    }

    public void searchSchedule() {
        System.out.println("검색 날짜를 입력하세요 예) yyyy-mm-dd");
        System.out.printf("DATE> ");
        String date = this.scanner.next();
        if (!isValidDateFormat(date)) {
            System.out.println("형식에 맞게 입력해주세요. 예) 2019-12-01");
            return;
        }

        if (schedule.existSchedules(date)) {
            System.out.println(schedule.searchSchedule(date));
        } else {
            System.out.println("일정이 없습니다.");
        }
    }

    public void addSchedule() {
        System.out.println("[일정 등록] 날짜를 입력하세요.");
        System.out.println("> ");
        String date = this.scanner.next();
        System.out.println("[일정 등록] 일정을 입력하세요.");
        System.out.println("> ");
        this.scanner.nextLine();
        String todo = this.scanner.nextLine();
        System.out.println(todo);

        if (isValidDateFormat(date)) {
            this.schedule.addSchedule(date, todo);
        } else {
            System.out.print("잘못 입력하셨습니다.");
        }
    }

    public boolean isValidDateFormat(String date) {
        String[] splitDate = date.split("-");
        if (splitDate.length != 3) {
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

    public void runCalendarPrompt() {
        // 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는
        Calendar cal = new Calendar();
        while (true) {
            System.out.println("년을 입력하세요. (exit: -1)");
            System.out.println("YEAR> ");
            int year = this.scanner.nextInt();

            if (year == -1) {
                break;
            }
            System.out.println("달을 입력하세요.");
            System.out.println("MONTH> ");
            int month = this.scanner.nextInt();

            if (month > 12 || month < 1) {
                System.out.println("잘못된 입력입니다.");
                break;
            }

            cal.printCalendar(year, month);
        }
        System.out.println("bye~");
        this.scanner.close();
    }

    public static void main(String args[]) {
        Prompt prompt = new Prompt();
//        prompt.runMenuPrompt();
    }
}
