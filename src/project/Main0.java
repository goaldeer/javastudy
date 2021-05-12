//jinhong@inje.ac.kr

package project;

public class Main0 {
    
    public static void main0(String[] args) {
        
        int[] intArray = new int[30];
        int[] index = new int[30];
        
        for (int i = 0; i <= 29; i++) {
            intArray[i] = 1000 + 1 + i;
        }
        
        String[] Num = new String[3];
        
        Num[0] = "Zero";
        Num[1] = "One";
        Num[2] = "Two";
        Num[2] = "Three";
        
        int ii = 0;
        for (int number : intArray) {
            
            index[ii] = number % 4;
            
            try {
                System.out.format("%d : %d > %s\n", ii + 1, intArray[ii], Num[index[ii]]);
                
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("");
            }
                
            ii += 1;
        }
    }
}
