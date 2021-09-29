package co.sy.lotto;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	
	private int[] lottoPaper;
	private int game;
	private int money;
	private int change;
	private Scanner sc = new Scanner(System.in);
	
	private void mainMenu() {
		System.out.println("* * * * * * * * * * [ LOTTO SYSTEM ] * * * * * * * * * *");
		insertMoney();
		changeMoney();
		if(game == 0) {
			return;
		}
		makeLottoNum();
	}
	
	private void makeLottoNum() {
		
		System.out.println("* * * * * * *[ LOTTO PAPER ]* * * * * * *");
		lottoPaper = new int[6];
		int paperNum = 1;
		System.out.println("[ " + paperNum++ +"번용지 ]ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ");
		
		for(int i = 1;  i <= game; i++) {
			boolean[] Flag = new boolean[46];			
			for(int j = 0 ; j < 6; j++) {
				int Num = (int)(Math.random() * 45) + 1;
				if(Flag[Num] == false) {
					Flag[Num] = true;
					lottoPaper[j] = Num;
				} else {
					j--;
				}
			}
			
			mySort();
			//Arrays.sort(lottoPaper);
			showNumber(i);
			
			if(i % 5 == 0 && i < game) {
				System.out.println("ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ");
				System.out.println("[ " + paperNum++ +"번용지 ]ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ");
			}
		}
		System.out.println("ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ");
		System.out.println("* * * * * * * * * * * * * * * * * * * * *");
	}
	
	private void showNumber(int gameNum) {
		
		System.out.printf("[ %2d ] GAME : ", gameNum);
		for(int i = 0 ; i < lottoPaper.length; i++) {
			System.out.printf("%3d ", lottoPaper[i]);
		}
		System.out.println("|");
	}
	
	private void changeMoney() {
		game = money / 1000;
		change = money % 1000;
		if(game == 0) {
			System.out.println("  - " + money + "원 입력하셨으므로 게임을 진행하실 수 없습니다.");
			System.out.println("  - " + money + "원을 돌려 드린 후, 프로그램 종료하겠습니다.");
			return;
		}
		System.out.println("  - " + money + "원 입력하셨으므로 총 '" + game + "게임'을 진행하실 수 있습니다.");
		System.out.println("  - " + money + "원 입력하셨으므로 '" + change + "원'을 거슬러 드리겠습니다.");
		System.out.println();
	}
	
	private int insertMoney() {
		System.out.print("* 금액을 입력하세요 (1000원 / 1게임) : ");
		money = sc.nextInt();
		System.out.println("* [ " + money + " ]원 입력하셨습니다.");
		return money;
	}
	
	private void mySort() {
		for(int i = 0 ; i < lottoPaper.length; i++) {
			int minIdx = i;
			for(int j = i + 1; j < lottoPaper.length; j++) {
				if(lottoPaper[j] < lottoPaper[minIdx]) {
					minIdx = j;
				}
			}
			int Temp = lottoPaper[i];
			lottoPaper[i] = lottoPaper[minIdx];
			lottoPaper[minIdx] = Temp;
		}
	}
	
	public void run() {
		mainMenu();
	}
}