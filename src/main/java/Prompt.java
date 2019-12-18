import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Prompt {
    private final static String PROPMPT = "cal> ";
    public void runPrompt() {
        // 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        String PROMPT = "cal> ";

        while(true) {
            System.out.println("달을 입력하세요.");
            System.out.println(PROMPT);
            int month = scanner.nextInt();
            if(month == -1) {
                break;
            }
            if(month > 12) {
                continue;
            }

            cal.printCalendar(month);
        }
        System.out.println("bye~");
        scanner.close();
    }
    public static void main(String args[]) {
       Prompt prompt = new Prompt();
       prompt.runPrompt();
    }


}
