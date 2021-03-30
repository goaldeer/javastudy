package project;
import java.util.Scanner;


public class Main {

    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("사용자가 입력한 수의 구구단 check 프로그램 V1.0 Alpha \n수를 입력하여 주세요.");
        
        int inputNum = 0;
        
        while (true) {
            try {
                inputNum = scan.nextInt();
                
                if (inputNum == 0 || inputNum > 99) {
                    System.out.println("0은 안됩니다.");
                    continue;
                }
                
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("정수만 입력해 주세요.");
                scan = new Scanner(System.in);
            }
        
        }
        
        
        
        scan.close();
        
        System.out.format("\n사용자가 입력한 값 %d\n\n", inputNum);
        
            MultiplyCheck(inputNum);
        
    }
    
    public static void MultiplyCheck(int input) {
        
        int x;
        int re = 0;
        
        x = input;
        
        for (int i = 1; i <= 9; i++) {
            for (int r = 1; r <= 9; r++) {
                if (i * r == x) {
                    System.out.format("%d * %d = %d\n", i, r, x);
                    re ++;
                }
            }
        }
        
        if (re == 0) {
            System.out.println("해당되는 구구단의 셈이 없습니다.");
        }
        
    }

}
