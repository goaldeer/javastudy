//jinhong@inje.ac.kr

package project;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;



public class Main {
    
    
    public static void main(String[] args) {
        
        int SIGAN = 10000;
        
        Scanner scan = new Scanner(System.in);
        
        Calendar cal = Calendar.getInstance(); //Calendar 객체 얻어오기 ( 시스템의 현재날짜와 시간정보 )
        Calendar fromDate = Calendar.getInstance();
        System.out.println("\n\n현재 일자\n" + cal.get(Calendar.YEAR) + "-" + String.valueOf(cal.get(Calendar.MONTH) + 1).toString() + "-" + cal.get(Calendar.DATE));
        
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        
        
        System.out.println("1만 시간의 법칙을 'JAVA Programming'에 적용해보자. V1.0 Alpha \n원하는 날짜를 입력해 주세요. (형식, 0000-00-00)");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = null;
        
        while(true) {
            try {
            //Parsing the String
                String datee = scan.next();
                date2 = dateFormat.parse(datee);
                fromDate.setTime(date2);
                
                if (fromDate.getTimeInMillis() - cal.getTimeInMillis() <= 0) {
                    System.out.println("과거는 입력할 수 없습니다.");
                    System.out.println("\n\n입력된 날짜.\n" + fromDate.get(Calendar.YEAR) + "-" + String.valueOf(fromDate.get(Calendar.MONTH) + 1).toString() + "-" + fromDate.get(Calendar.DATE));
                    scan = new Scanner(System.in);
                    continue;
                } 
                break;
                
            } catch (ParseException e) {
            // TODO Auto-generated catch block
                scan = new Scanner(System.in);
                System.out.println("제대로 된 형식으로 입력해 주세요. \n");
            }
        }
        
        System.out.println("\n\n입력된 날짜.\n" + fromDate.get(Calendar.YEAR) + "-" + String.valueOf(fromDate.get(Calendar.MONTH) + 1).toString() + "-" + fromDate.get(Calendar.DATE));
        
        scan.close();
        
        long diffSec = (fromDate.getTimeInMillis() - cal.getTimeInMillis()) / 1000;
        long diffDays = diffSec / (24 * 60 * 60);
        long result = SIGAN / diffDays;
        
        System.out.format("1만 시간의 법칙을 위해서는, 지정된 날짜까지 하루에 %d시간 공부해야 합니다.\n", result);
        
    }
    
}
