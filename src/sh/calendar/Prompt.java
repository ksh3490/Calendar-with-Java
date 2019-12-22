package sh.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
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

			if (month > 12) {
				System.out.println("올바른 값을 입력하세요");
				continue;
			}

			if (month < 1) {
				System.out.println("올바른 값을 입력하세요");
				continue;
			}

			cal.printCalendar(month);

		}
	}

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();

//		monthInput.close();
	}

}
