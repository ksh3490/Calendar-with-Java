package sh.calendar;

import java.lang.annotation.Repeatable;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MONTH_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] WEEK_DAYS = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	public int getStartDay (String day) {
		int startDay = -1;
		
		for (int i = 0; i < WEEK_DAYS.length; i++) {
			if (WEEK_DAYS[i] == day) {
				startDay = i;
				break;
			}
		}
		
		return startDay;
	}
	
	public boolean isLeapYear (int year) {
		
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printCalendar(int year, int month, String day) {
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		
		int startDay = getStartDay(day);		
		int maxDay = daysOfMonth(year, month);
		
		int startSpaceNum = startDay * 3;
		String repeatedSpace = "";
		
		for (int i = 1; i <= startSpaceNum; i++) {
			repeatedSpace.concat(" ");
		}
		
		
		System.out.print(repeatedSpace);
		
		for(int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		
	}

	
	public int daysOfMonth(int year, int month) {
		
		if (isLeapYear(year) == true) {
			return LEAP_MONTH_DAYS[month - 1];
		} else {			
			return MONTH_DAYS[month - 1];
		}

	}

}
