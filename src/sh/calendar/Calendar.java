package sh.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int daysOfMonth(int month) {

		return MONTH_DAYS[month - 1];

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Scanner monthInput = new Scanner(System.in);
		Calendar cal = new Calendar();
		System.out.println("반복 횟수를 입력하세요");
		int num = input.nextInt();
		
		for (int i = 1; i <= num; i++) {
			System.out.println("계산할 달을 입력하세요");
			int month = monthInput.nextInt();
			System.out.printf("%d월은 %d일까지 있습니다\n", month, cal.daysOfMonth(month));
		}
		System.out.println("설정한 반복 횟수가 끝났습니다");

		input.close();
		monthInput.close();
	}
}
