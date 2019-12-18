package sh.calendar;

import java.util.Scanner;

public class Calendar {
	
	private static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int daysOfMonth(int month) {

		return MONTH_DAYS[month - 1];
		
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Calendar cal = new Calendar();
		System.out.println("조회할 달을 입력해 주세요");
		int num = input.nextInt();
		
		System.out.printf("%d월은 %d일까지 있습니다\n", num, cal.daysOfMonth(num));
		
		input.close();
	}
}
