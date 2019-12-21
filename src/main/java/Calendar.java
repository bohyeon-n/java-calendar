import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Calendar {

    private static final int[] MAX_DAYS =  {0, 31, 28, 31, 30,31,30, 31, 31, 30, 31, 30, 31 };
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30,31,30, 31, 31, 30, 31, 30, 31 };
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static boolean  isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ) {
            return true;
        }
        return false;
    }

    public static int getMaxDaysOfMonth(int year, int month) {
        if(isLeapYear(year)) {
            return LEAP_MAX_DAYS[month];
        }
        return MAX_DAYS[month];
    }

    public void printSampleCalendar() {
        System.out.println(" MO TU WE TH FR SA SU");
        System.out.println("----------------------------");
        System.out.println(" 1  2  3   4   5   6  7   8");
        System.out.println(" 9 10 11  12  13  14 15  16");
        System.out.println("17 18 19  20  21  22 23  24");
        System.out.println("25 26 27  28  29  30 31  32");
    }

    public static int getWeekDay(int year, int month) {
        int count = 0;
        final int  sYear = 1970;
        final int sWeekDay = 4;

        for(int i = sYear; i < year; i++) {
            boolean isLeapYear = isLeapYear(i);
            count += isLeapYear ? 366 : 365;
        }
        for(int i = 1; i < month; i++) {
            int delta = getMaxDaysOfMonth(year, i);
            count += delta;
        }
        int weekDay  = (count + sWeekDay) % 7;
        return weekDay;
    }

    public void printCalendar(int year, int month, Schedule schedule) {
        int lastDays = getMaxDaysOfMonth(year, month);
        int weekDay = getWeekDay(year , month);

        int days [] = new int[lastDays + weekDay];
        for(int i = 0; i < weekDay;i++) {
            days[i] = 0;
        }
        for(int i = weekDay; i < days.length; i++) {
            days[i] = i+ 1 - weekDay;
        }
        int week = lastDays / 7;
        if(week % 7 != 0) {
            week++;
        }
        int [] [] weekDays = new int[week][];
        for(int i = 0; i < week; i++) {
           weekDays[i] = Arrays.copyOfRange(days, i *7, (i +1) * 7);
        }
        System.out.println(" SU MO TU WE TH FR SA ");
        System.out.println("----------------------------");
        for(int i = 0; i < weekDays.length; i++) {
            String weekString = "";
            for(int j = 0; j < weekDays[i].length; j++) {
                if(weekDays[i][j] != 0) {
                    weekString += weekDays[i][j];
                    String dateFormat = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", weekDays[i][j]);

                    if(schedule.existSchedules(dateFormat)) {
                        weekString += ANSI_RESET +  ANSI_RED +  "*" + ANSI_RED + ANSI_RESET;
                    }else {
                        weekString += " ";
                    }
                }else {
                    weekString   += "  ";
                }
            }
            System.out.printf(" %s", weekString);
            System.out.println();
        }
    }
}
