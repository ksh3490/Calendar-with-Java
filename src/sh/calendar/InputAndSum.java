package sh.calendar;

import java.util.Scanner;

public class InputAndSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("두 수를 입력하세요");
		String value = input.nextLine();
		String first = value.split(" ")[0];
		String second = value.split(" ")[1];
		
		int intFirst = Integer.parseInt(first);
		int intSecond = Integer.parseInt(second);
		
		int result = intFirst + intSecond;
		
		System.out.printf("두 수의 합은 %d입니다.", result);
		input.close();
	}
}
