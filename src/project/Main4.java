//jinhong@inje.ac.kr

package project;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.lang.String;


public class Main4 {
    
    static int SIGAN = 10000;
    
    public static void main(String[] args) {
        
        int mod = 0;
        
        Scanner scan = new Scanner(System.in);
        
        Calendar cal = Calendar.getInstance(); //Calendar 객체 얻어오기 ( 시스템의 현재날짜와 시간정보 )
        Calendar fromDate = Calendar.getInstance();
        
        System.out.println("\n\n현재 일자\n" + cal.get(Calendar.YEAR) + "-" + String.valueOf(cal.get(Calendar.MONTH) + 1).toString() + "-" + cal.get(Calendar.DATE));
        
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        
        
        System.out.println("1만 시간의 법칙을 'JAVA Programming'에 적용해보자. V1.1 Alpha \n-----모드를 선택하세요-----. \n");
        System.out.println("\n1 : 평일 5시간 주말 시간 공부전략 \n2 : 무한 공부전략(24시간 미만)\n입력 예시 : 1 또는 2");
        
        while(true) {
            try {
                mod = scan.nextInt();
                
                if (mod == 1 || mod == 2) {
                    break;
                }
                
                System.out.println("1번 또는 2번만 입력해 주세요, 다른 숫자는 불가능 합니다.");
                scan = new Scanner(System.in);
                continue;
                
            } catch (InputMismatchException e) {
                System.out.println("숫자, 1번 또는 2번을 입력해 주세요.");
                scan = new Scanner(System.in);
            }
        }
        
        scan.close();
        
        if (mod == 1) {
            LifeGoesOn();
        } else if (mod == 2) {
            NoLife(cal, fromDate);
        }
        
        
    }
    
    public static Calendar DateInput(Calendar cal, Calendar fromDate) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("원하는 날짜를 입력해 주세요. (형식, 0000-00-00)");

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
                
                scan = new Scanner(System.in);
                System.out.println("제대로 된 형식으로 입력해 주세요. \n");
            }
        }
        
        System.out.println("\n\n입력된 날짜.\n" + fromDate.get(Calendar.YEAR) + "-" + String.valueOf(fromDate.get(Calendar.MONTH) + 1).toString() + "-" + fromDate.get(Calendar.DATE));
        scan.close();
        
        return fromDate;
        
    }
    
    public static void LifeGoesOn() {
        Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.DATE, getStudyDays());
        
        System.out.println("\n\n출소일 : " + cal.get(Calendar.YEAR) + "-" + String.valueOf(cal.get(Calendar.MONTH) + 1).toString() + "-" + cal.get(Calendar.DATE));
        
    }
    
    public static int getStudyDays() {
        Calendar cal = Calendar.getInstance();
        int dayNum = cal.get(Calendar.DAY_OF_WEEK);
        int times = 0;
        int days = 0;
        
        
        for (int i = 1; 10000 - times > 0; i ++) {
            dayNum = cal.get(Calendar.DAY_OF_WEEK);
             days = i;
            switch(dayNum){
                case 1:
                case 7:
                    times = times + 7; //"일";
                    break;
     
                case 2: //월, 화, 수, 목
                case 3:
                case 4:
                case 5:
                case 6:
                    times = times + 5; //"금";        
                    break;
                }
            cal.add(Calendar.DATE, 1);
            
        }
        
  return days;
}

    
    public static void NoLife(Calendar cal, Calendar fromDate) {
        
        fromDate = DateInput(cal, fromDate);
        
        
        long diffSec = (fromDate.getTimeInMillis() - cal.getTimeInMillis()) / 1000;
        long diffDays = diffSec / (24 * 60 * 60);
        long result = SIGAN / diffDays;
        
        System.out.format("1만 시간의 법칙을 위해서는, 지정된 날짜까지 하루에 %d시간 공부해야 합니다.\n", result);
    }
    
}
