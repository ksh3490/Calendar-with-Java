package sh.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] MONTH_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MONTH_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String SAVE_FILE = "calendar.dat";
	
	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if (!f.exists()) {
			System.err.println("저장된 파일이 없습니다");
			return;
		}
		
		try {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1].replaceAll("\"", "");
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerPlan(String strDate, String plan) {
		PlanItem p =new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}

	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public void printCalendar(int year, int month) {

		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");

		int maxDay = daysOfMonth(year, month);
		int startDay = getStartDay(year, month, 1);

		// insert spaces
		for (int i = 1; i <= startDay; i++) {
			System.out.print("   ");
		}

		// print days of month
		int count = 7 - startDay;
		int delim = (count < 7) ? count : 0;

		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}

		System.out.println();

		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();

	}

	// Get Starting Weekday with counting
	private int getStartDay(int year, int month, int day) {
		int standardYear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970. 1. 1 Thursday

		int count = 0;

		// Count Days of Years
		for (int i = standardYear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		// Count Days of Months
		for (int i = 1; i < month; i++) {
			int delta = daysOfMonth(year, i);
			count += delta;
		}

		// Count Days
		count += day - 1;

		int startDay = (count + STANDARD_WEEKDAY) % 7;

		return startDay;
	}

	// Return the Number of Days
	public int daysOfMonth(int year, int month) {

		if (isLeapYear(year)) {
			return LEAP_MONTH_DAYS[month];
		} else {
			return MONTH_DAYS[month];
		}

	}

}
