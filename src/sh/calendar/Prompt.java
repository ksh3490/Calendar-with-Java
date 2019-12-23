package sh.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPTYEAR = "YEAR> ";
	private final static String PROMPTMONTH = "MONTH> ";
	private final static String PROMPTDAY = "DAY> ";

	public void runPrompt() {
		Scanner yearInput = new Scanner(System.in);
		Scanner monthInput = new Scanner(System.in);
		Scanner dayInput = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = -1;
		int year = -1;
		String day = "";
		while (true) {
			System.out.println("출력하려는 연도를 입력하세요");
			System.out.print(PROMPTYEAR);
			year = yearInput.nextInt();
			System.out.println("출력하려는 달을 입력하세요");
			System.out.print(PROMPTMONTH);
			month = monthInput.nextInt();
			System.out.println("시작하는 요일을 입력하세요");
			System.out.print(PROMPTDAY);
			day = dayInput.nextLine();

			if (month == -1) {
				System.out.println("달력 출력을 종료합니다");
				break;
			}

			if (month > 12) {
				System.out.println("올바른 값을 입력하세요");
				continue;
			}

			if (month < 1) {
				System.out.println("올바른 값을 입력하세요");
				continue;
			}

			cal.printCalendar(year, month, day);

		}
		
		yearInput.close();
		monthInput.close();
		dayInput.close();
		
	}

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
