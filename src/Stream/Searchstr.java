package Stream;

import java.io.*;

public class Searchstr {
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
        File Foinitial = new File(srcFolder);
        String[] flists = Foinitial.list();
        for (int i = 0; i < flists.length; i++) {
            searchfile(srcFolder + "/" + flists[i], targetstr);
        }
    }
    public static void main(String[] args) {
        String srcFolder,targetstr;
        srcFolder = "e:/python学习/forcopy";
        targetstr = "magic";
        copyfolder(srcFolder,targetstr);
    }
}
