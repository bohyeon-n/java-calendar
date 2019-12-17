import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS =  {31, 28, 31, 30,31,30, 31, 31, 30, 31, 30, 31 };
    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month -1 ];
    }

    public void printSampleCalendar() {
        System.out.println(" 일 월 화 수 목 금 토 일");
        System.out.println("----------------------------");
        System.out.println(" 1  2  3   4   5   6  7   8");
        System.out.println(" 9 10 11  12  13  14 15  16");
        System.out.println("17 18 19  20  21  22 23  24");
        System.out.println("25 26 27  28  29  30 31  32");
    }
    public static void main(String[] args) {
        // 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는
        Scanner  scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        System.out.println("달을 입력하세요.");
        int month =  scanner.nextInt();
        System.out.printf("%d 월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
        cal.printSampleCalendar();
        scanner.close();
    }

}
