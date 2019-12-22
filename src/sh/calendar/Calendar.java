package sh.calendar;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void createLastArray(String[] arr, int numOfDays) {
		for (int i = 0; i < numOfDays; i++) {
			int day = i + 29;
			arr[i] = Integer.toString(day);
		}

		String joinedString = String.join(" ", arr);

		System.out.println(joinedString);

	}

	public void basicCalendarPrint() {
		System.out.println(" 일 월  화  수 목  금  토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public int daysOfMonth(int month) {

		return MONTH_DAYS[month - 1];
	}

}
