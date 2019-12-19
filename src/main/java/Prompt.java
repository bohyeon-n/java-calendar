import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Prompt {
    public void runPrompt() {
        // 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        while(true) {
            System.out.println("년을 입력하세요. (exit: -1)");
            System.out.println("YEAR> ");
            int year = scanner.nextInt();

            if(year == -1) {
                break;
            }
            System.out.println("달을 입력하세요.");
            System.out.println("MONTH> ");
            int month = scanner.nextInt();

            if(month > 12 || month < 1)  {
                System.out.println("잘못된 입력입니다.");
                break;
            }

            cal.printCalendar(year, month);
        }
        System.out.println("bye~");
        scanner.close();
    }

    public static void main(String args[]) {
       Prompt prompt = new Prompt();
       prompt.runPrompt();
    }


}
