package sh.calendar;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void printCalendar(int month) {
		System.out.println("  일 월  화  수 목  금  토");
		System.out.println(" --------------------");
		
		int maxDay =daysOfMonth(month);
		
		for(int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		
	}

	public int daysOfMonth(int month) {

		return MONTH_DAYS[month - 1];
	}

}
