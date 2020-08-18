package multiplethread;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Testfilr {
    //搜索字符串
    public static void searchfile(String srcFile, String targetstr){
        File finitial = new File(srcFile);
        String tstr = targetstr;
        try(FileReader fr = new FileReader(finitial);BufferedReader br = new BufferedReader(fr);){
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
    //遍历文件夹,调用searchfile
    public static void copyfolder(String srcFolder, String targetstr) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        File Foinitial = new File(srcFolder);
        String[] flists = Foinitial.list();
        for (int i = 0; i < flists.length; i++) {
            if (flists[i].endsWith(".py")){
//                SearvhThread search1 = new SearvhThread(srcFolder + "/" + flists[i],targetstr);
//                new Thread(search1).start();
                String finstr = srcFolder + "/" + flists[i];
                threadPool.execute(new Runnable() {
                    public void run() {searchfile(finstr,targetstr);}

                });
            }
        }
    }
    public static void main(String[] args) {
        String srcFolder,targetstr;
        srcFolder = "e:/python学习/forcopy";
        targetstr = "magic";
        copyfolder(srcFolder,targetstr);
    }
}

