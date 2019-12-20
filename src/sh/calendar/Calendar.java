package sh.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int daysOfMonth(int month) {

		return MONTH_DAYS[month - 1];

	}

	public static void main(String[] args) {
		
		String PROMPT = "cal> ";
		Scanner monthInput = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		
		int month = 0;
		while (true) {
			System.out.println("계산할 달을 입력하세요");
			System.out.print(PROMPT);
			month = monthInput.nextInt();
			if(month == -1) {
				break;
			}
			
			if(month > 12) {
				continue;
			}
			
			System.out.printf("%d월은 %d일까지 있습니다\n", month, cal.daysOfMonth(month));
		}

		System.out.println("Have a lovely day!");

		monthInput.close();
	}
}
