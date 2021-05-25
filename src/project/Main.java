//jinhong@inje.ac.kr

package project;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        Book book = new Book();
        book.showMain();
    }
    
    public static void writer() throws InterruptedException {
        try {
            String createfile="/workspace/JAVA_study/csvfile.csv";
            FileWriter fw = new FileWriter(createfile);

            fw.append("NO");
            fw.append(',');
            fw.append("TIME");
            fw.append(',');
            fw.append("Vib1");
            fw.append('\n');
            
            for(true) {
                fw.append();
                fw.append();
                
            }

            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void reader() {
        String path = "/workspace/JAVA_study/csvfile.csv";
        //List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get(path));
            //Charset.forName("UTF-8");
            String line = "";
            
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
                Book bb = new Book();
                bb.setbNo(array[0]);
                bb.setbTitle(array[1]);
                bb.setbAuthor(array[2]);
                bb.setbPrice(array[3]);
                
                Book.bookList.add(bb);
                //ret.add(tmpList);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}