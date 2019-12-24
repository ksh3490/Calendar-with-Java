package sh.calendar;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MONTH_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] WEEK_DAYS = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };
	private static final int[] DAY_DIVIDER = { 7, 6, 5, 4, 3, 2, 1 };

	public int getStartDay(String day) {
		int startDay = -1;

		for (int i = 0; i < WEEK_DAYS.length; i++) {
			if (WEEK_DAYS[i].equals(day)) {
				startDay = i;
				break;
			}
		}

		return startDay;

	}

	public boolean isLeapYear(int year) {

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
		int dayDivider = DAY_DIVIDER[startDay];

		// insert spaces
		for (int i = 1; i <= startDay; i++) {
			System.out.print("   ");
		}

		// print days of month
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);

			if (i == dayDivider || i == dayDivider + 7 ) {
				System.out.println();
				dayDivider = i;
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
