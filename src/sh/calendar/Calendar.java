package sh.calendar;

import java.util.Arrays;
import java.util.Scanner;

public class Calendar {

	private static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void createLastArray(int[] arr, int numOfDays) {
		for (int i = 0; i < numOfDays; i++) {
			int day = i + 29;
			arr[i] = day;
		}

		String stringArr = Arrays.toString(arr);

		String joinedString = String.join(" ", stringArr);

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

	public static void main(String[] args) {

		String PROMPT = "cal> ";
		Scanner monthInput = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		while (true) {
			System.out.println("출력하려는 달을 입력하세요");
			System.out.print(PROMPT);
			month = monthInput.nextInt();

			if (month == -1) {
				System.out.println("달력 출력을 종료합니다");
				break;
			}

			if (month == 2) {
				cal.basicCalendarPrint();
				continue;
			}

			if (month > 12) {
				System.out.println("올바른 값을 입력하세요");
				continue;
			}

			int size = cal.daysOfMonth(month) - 28;
			int[] intLastArray = new int[size];

			cal.basicCalendarPrint();
			cal.createLastArray(intLastArray, size);

		}

		monthInput.close();
	}
}
