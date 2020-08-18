package multiplethread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchPool implements Runnable{
    private String srcFile;
    private String tstr;
    public SearchPool(String srcFile1, String targetstr){
        this.srcFile = srcFile1;
        this.tstr = targetstr;
    }
    public void run(){
        File finitial = new File(srcFile);
//        String tstr = targetstr;
        try(FileReader fr = new FileReader(finitial); BufferedReader br = new BufferedReader(fr);){
            String line;
            while((line = br.readLine()) != null)
                if ((line.indexOf(tstr))>0){
                    System.out.println(line);
                    System.out.println(srcFile);
                }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
