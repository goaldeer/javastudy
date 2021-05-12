//jinhong@inje.ac.kr

package project;
<<<<<<< HEAD
import java.io.RandomAccessFile;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.text.SimpleDateFormat;
import java.nio.file.*;
=======
>>>>>>> 09c775b16f59a7da8731617500053b4ecabd5816


/* 

1. 지정된 경로의 모든 파일명을 읽어 리스트로 저장하기. File[]

2. 0번 인덱스 부터 시작해서 파일을 순서대로 읽기
2-1. 파싱 프로그램을 이용해서 c - l - a - s - s 를 읽을 시에, 공백을 기준으로 하여 그 뒤의 이름 읽어와 List에 넣기.

*/

public class Main {
    
<<<<<<< HEAD
    static File[] workingFiles;
    static int count = 0;
    static Scanner scan;
    static ArrayList<File> studentList = new ArrayList<File>();
    static String[][] Scores;
    
    public static void main(String args[]) {
        
        long systemTime = System.currentTimeMillis(); 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String dTime = formatter.format(systemTime);
    
        String workingPath = Paths.get("HIT_Java", dTime).toAbsolutePath().toString();
        String inputPath = workingPath + File.separatorChar + "Inputs"; //폴더 경로

        
        if (makeFolder(inputPath)) {
            System.out.println("Inputs 폴더 생성 완료, zip 파일들을 알맞은 일자의 폴더에 넣어주세요.");
            System.out.printf("모두 옮겼으면,");
        }
    
        while (true) {
            scan = new Scanner(System.in);
            String dummyData = null;
        
            try {
                System.out.println("아무 키나 입력 후 엔터를 눌러 주세요...");
                dummyData = scan.nextLine();
                
            } catch (java.util.InputMismatchException e) {
                continue;
            }
            
        
            File f = new File(inputPath);
            File[] fileList = f.listFiles();
            
            try {
                
                if (fileList.length == 0) {
                    scan = new Scanner(System.in);
                    throw new Exception("압축파일이 존재하지 않습니다.\n");
                }
                
                for (File file : fileList) {
                    if (file.isFile()) {
                        String fileName = file.getAbsolutePath();
                        if (unZip(fileName, workingPath + File.separatorChar + "working" + File.separatorChar + file.getName().substring(0, file.getName().lastIndexOf(".")))) {
                            
                        }
                    }
                }
                
                scan.close();
                break;
            } catch (Exception e) {
                System.out.println("\n\nERROR : " + e + "\n다시 시도해 주세요..");
                continue;
            }
        }
        
        System.out.println("\n\n\n제출자 명단 - \n");
        
        for (File ff : studentList) {
            System.out.println(ff.getName());
        }
        
        System.out.println("채점 DONE");
        
    }
    
    static int classCounter = 0;
    private static void ClassReader(File fi) {
        
        try {
            
                ArrayList<String> classList = new ArrayList<String>();
                String str = null;
                String ss = "";
                    
                char[] c = new char[(int)fi.length()];
                BufferedReader br = new BufferedReader(new FileReader(fi));
                br.read(c);
            
                for(int i = 0; i < c.length; i++) {
                    if (c[i] == 'c') {
                        if (c[i + 1] == 'l') {
                            if (c[i + 2] == 'a') {
                                if (c[i + 3] == 's') {
                                    if (c[i + 4] == 's') {
                                        int cc = 6;
                                        ss = "";
                                        while (true) {
                                            if (c[i + cc] == ' ') {
                                                classList.add(ss);
                                                classCounter++;
                                                break;
                                            }
                                            ss = ss + String.valueOf(c[i + cc]);
                                            cc++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                for (String s : classList) {
                    System.out.println(s);
                }
                
                str = str + String.valueOf(c);
                //System.out.print(str);
                br.close();
                
            } catch ( IOException e ) {
                System.out.println(e);
            }
            
            if (fi.isFile()) {
                //System.out.println("채점완료..");
            }
        
    }
    
    //안씀
    private static File[] ListLayerFile(String strDirPath) {
        File path = new File(strDirPath); 
        File[] fList = path.listFiles();
        ArrayList<File> result = new ArrayList<File>();
        
        for(File fl : fList) { 
            if(fl.isFile()) { 
                System.out.println(fl.getPath()); // 파일의 FullPath 출력
                result.add(fl);
            } else if(fl.isDirectory()) { 
                ListLayerFile(fl.getPath()); // 재귀함수 호출 
            } 
        } 
        
        return fList;
    }

    
    public static boolean unZip(String zipPath, String zipUnzipPath) {
        int zipCount = 0;
        classCounter = 0;
        
        // 파일 정상적으로 압축이 해제가 되어는가. 
        boolean isChk = false; 
        // 해제할 홀더 위치를 재조정 
        zipUnzipPath = zipUnzipPath.replace(".zip", ""); 
        // zip 파일 
        File zipFile = new File(zipPath); 
        FileInputStream fis = null; 
        ZipInputStream zis = null; 
        ZipEntry zipentry = null; 
        File ffile = new File(zipUnzipPath);
        
        
        
        try {
            
            System.out.println("\n" + zipFile.getName().substring(0, zipFile.getName().lastIndexOf(".")) + " ---------------- ");
            
            // zipFileName을 통해서 폴더 만들기 
            if (makeFolder(zipUnzipPath)) { 
                //System.out.println("압축 해제 경로 설정중...");       
                studentList.add(ffile);
            } 
            // 파일 스트림 
            fis = new FileInputStream(zipFile); 
            // Zip 파일 스트림 
            zis = new ZipInputStream(fis, Charset.forName("EUC-KR")); 
            // 압축되어 있는 ZIP 파일의 목록 조회 
            while ((zipentry = zis.getNextEntry()) != null) { 
                String filename = zipentry.getName(); 
                //System.out.println("압축 해제중... => " + filename); 
                File file = new File(zipUnzipPath, filename); 
                // entiry가 폴더면 폴더 생성 
                if (zipentry.isDirectory()) { 
                    //System.out.println("zipentry가 디렉토리입니다."); 
                    file.mkdirs(); 
                } else { 
                    // 파일이면 파일 만들기 
                    //System.out.println("zipentry가 파일입니다."); 
                    try { 
                        createFile(file, zis);
                        System.out.println("\n파일 용량 : " + String.valueOf(file.length()) + " byte");
                        ClassReader(file);
                        zipCount++;
                        
                    } catch (Throwable e) {
                        e.printStackTrace();
                    } 
                } 
            }
            
            isChk = true; 
            System.out.println(zipFile.getName().substring(0, zipFile.getName().lastIndexOf(".")) + " : " + String.valueOf(zipCount) + "개의 파일, " + String.valueOf(classCounter) + "개의 클래스.\n");
        } catch (Exception e) { 
            isChk = false; 
            
        } finally { 
            if (zis != null) { 
                try { zis.close(); 
                    } catch (IOException e) {
                } 
            } 
            
            if (fis != null) { 
                try { fis.close(); 
                    } catch (IOException e) {
                } 
            } 
        } 
        return isChk; 
    }
    
    /** 
    * @param folder - 생성할 폴더 경로와 이름 */ 
    
    private static boolean makeFolder(String folder) { 
        if (folder.length() < 0) { 
            return false; 
        } 
        String path = folder; 
        
        // 폴더 경로 
        File Folder = new File(path); 
        
        // 해당 디렉토리가 없을경우 디렉토리를 생성합니다. 
        if (!Folder.exists()) {
            try { 
                Folder.mkdirs(); 
                
                // 폴더 생성합니다. 
                //System.out.println("폴더가 생성되었습니다.");
            } catch (Exception e) { 
                e.getStackTrace(); 
            } 
        } else { 
            //System.out.println("이미 폴더가 생성되어 있습니다."); 
        }
        return true; 
    }
    
    /** 
    * 파일 만들기 메소드 * 
    * @param file 파일 * 
    @param zis Zip스트림 
    */
    
    private static void createFile(File file, ZipInputStream zis) throws Throwable {
        // 디렉토리 확인 
        File parentDir = new File(file.getParent()); 
        // 디렉토리가 없으면 생성하자
        if (!parentDir.exists()) {
            parentDir.mkdirs(); 
        } 
        FileOutputStream fos = null; 
        // 파일 스트림 선언 
        try { 
            fos = new FileOutputStream(file); 
            byte[] buffer = new byte[256]; 
            int size = 0; 
            // Zip스트림으로부터 byte뽑아내기 
            while ((size = zis.read(buffer)) > 0) { 
                // byte로 파일 만들기 
                fos.write(buffer, 0, size); 
            } 
        } catch (Throwable e) {
            throw e; 
        } finally {
            if (fos != null) {
                try { 
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
    }
=======
    public static void main(String[] args) {
        
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
                System.out.format("%d : %d > %s\n", ii, intArray[ii], Num[index[ii]]);
                
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("");
            }
                
            ii += 1;
        }
    }
>>>>>>> 09c775b16f59a7da8731617500053b4ecabd5816
}
