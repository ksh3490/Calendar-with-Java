package sh.calendar;

import java.text.ParseException;
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

	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				cmdHelp();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}

		System.out.println("Bye~");
		scanner.close();

	}

	private void cmdHelp() {
		return;
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

	private void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[일정 검색]");
		System.out.println("검색할 날짜를 입력해 주세요.(yyyy-mm-dd)");
		String date = s.next();
		PlanItem plan;
		plan = c.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 존재하지 않습니다.");
		}
	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요.(yyyy-mm-dd)");
		String date = s.next();
		
		s.nextLine(); //Ignore one new line
		System.out.println("일정을 입력해 주세요.");
		String plan = s.nextLine();
		
		c.registerPlan(date, plan);
	}

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
