import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS =  {31, 28, 31, 30,31,30, 31, 31, 30, 31, 30, 31 };
    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month -1 ];
    }

    public void printSampleCalendar() {
        System.out.println(" MO TU WE TU FR SA SU");
        System.out.println("----------------------------");
        System.out.println(" 1  2  3   4   5   6  7   8");
        System.out.println(" 9 10 11  12  13  14 15  16");
        System.out.println("17 18 19  20  21  22 23  24");
        System.out.println("25 26 27  28  29  30 31  32");
    }

    public void printCalendar( int month) {
        int lastDays = getMaxDaysOfMonth(month);
        int days [] = new int[lastDays];
        for(int i = 0; i < days.length; i++) {
            days[i] = i+ 1;
        }
        int week = lastDays / 7;
        if(week % 7 != 0) {
            week++;
        }
        int [] [] weekDays = new int[week][];
        for(int i = 0; i < week; i++) {
           weekDays[i] = Arrays.copyOfRange(days, i *7, (i +1) * 7);
        }
        System.out.println(" 일 월 화 수 목 금 토 일");
        System.out.println("----------------------------");
        for(int i = 0; i < weekDays.length; i++) {
            String weekString = "";
            for(int j = 0; j < weekDays[i].length; j++) {
                if(weekDays[i][j] != 0) {
                    weekString += weekDays[i][j] + " ";
                }
            }
            System.out.println(weekString);
        }
    }
}
