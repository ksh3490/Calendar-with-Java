package sh.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPTYEAR = "YEAR> ";
	private final static String PROMPTMONTH = "MONTH> ";

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public void runPrompt() {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			if (cmd.equals("1"))
				cmdRegister();
			else if (cmd.equals("2"))
				cmdSearch();
			else if (cmd.equals("3"))
				cmdCal(scanner, cal);
			else if (cmd.equals("h"))
				cmdHelp();
			else if (cmd.equals("q"))
				break;

		}

		System.out.println("Bye~");
		scanner.close();

	}

	private void cmdHelp() {
		// TODO Auto-generated method stub

	}

	private void cmdCal(Scanner s, Calendar c) {
		int month = 1;
		int year = 1;

		System.out.println("출력하려는 연도를 입력하세요");
		System.out.print(PROMPTYEAR);
		year = s.nextInt();

		System.out.println("출력하려는 달을 입력하세요");
		System.out.print(PROMPTMONTH);
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("올바른 값을 입력하세요");
			return;
		}

		c.printCalendar(year, month);
	}

	private void cmdSearch() {
		// TODO Auto-generated method stub

	}

	private void cmdRegister() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
