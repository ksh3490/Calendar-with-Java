package sh.calendar;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Calendar {
	public static void main(String[] args) {
		int[] thirtyOne = new int[]{1, 3, 5, 7, 8, 10, 12};
		int[] thirty = new int[]{4, 6, 9, 11};
		int feb = 2;
		
		Scanner input = new Scanner(System.in);
		System.out.println("조회할 달을 입력해 주세요");
		int num = input.nextInt();
		
		if(IntStream.of(thirtyOne).anyMatch(x -> x == num)) {
			System.out.printf("%d월은 31일까지 있습니다\n", num);
		} else if(IntStream.of(thirty).anyMatch(x -> x == num)) {
			System.out.printf("%d월은 30일까지 있습니다\n", num);
		} else if(num == feb) {
			System.out.printf("%d월은 28일까지 있습니다\n", num);
		} else {
			System.out.printf("%d월은 존재하지 않습니다\n", num);
		}
		
		input.close();
	}
}
