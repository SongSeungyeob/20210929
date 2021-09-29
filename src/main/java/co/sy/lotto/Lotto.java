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
		System.out.println("[ " + paperNum++ +"������ ]�� �� �� �� �� �� �� �� �� �� �� �� ��");
		
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
				System.out.println("�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��");
				System.out.println("[ " + paperNum++ +"������ ]�� �� �� �� �� �� �� �� �� �� �� �� ��");
			}
		}
		System.out.println("�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��");
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
			System.out.println("  - " + money + "�� �Է��ϼ����Ƿ� ������ �����Ͻ� �� �����ϴ�.");
			System.out.println("  - " + money + "���� ���� �帰 ��, ���α׷� �����ϰڽ��ϴ�.");
			return;
		}
		System.out.println("  - " + money + "�� �Է��ϼ����Ƿ� �� '" + game + "����'�� �����Ͻ� �� �ֽ��ϴ�.");
		System.out.println("  - " + money + "�� �Է��ϼ����Ƿ� '" + change + "��'�� �Ž��� �帮�ڽ��ϴ�.");
		System.out.println();
	}
	
	private int insertMoney() {
		System.out.print("* �ݾ��� �Է��ϼ��� (1000�� / 1����) : ");
		money = sc.nextInt();
		System.out.println("* [ " + money + " ]�� �Է��ϼ̽��ϴ�.");
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