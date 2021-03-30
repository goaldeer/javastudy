package project;
import java.util.Scanner;


public class Main2 {

    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("사용자가 입력한 수의 구구단 출력 프로그램 V1.0 Alpha \n수를 입력하여 주세요.");
        
        int inputNum = 0;
        
        while (true) {
            try {
                inputNum = scan.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("정수만 입력해 주세요.");
                scan = new Scanner(System.in);
            }
        
        }
        
        
        
        scan.close();
        
        System.out.format("\n사용자가 입력한 값 %d\n\n", inputNum);
        
        for(int i = 1; i <= 9; i++) {
            System.out.format("%d x %d = %d\n", inputNum, i,Multiply(inputNum, i));
            
        }
        
        
    }
    
    public static int Multiply(int input, int count) {
        
        int x;
        int y;
        int z;
        
        x = input;
        y = count;
        
        z = x * y;
        
        return z;
    }

}
