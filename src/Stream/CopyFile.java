package Stream;

import java.io.*;

public class CopyFile {
    //复制文件
    public static void copyfile(String srcFile, String destFile){
        File finitial = new File(srcFile);
        File fout = new File(destFile);
        try(FileReader fr = new FileReader(finitial);BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(fout);PrintWriter pw = new PrintWriter(fw);){
            String line;
            while((line = br.readLine()) != null)
                pw.println(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //复制文件夹,调用copyfile
    public static void copyfolder(String srcFolder, String destFolder){
        File Foinitial = new File(srcFolder);
        File Foout = new File(destFolder);
        String[] flists= Foinitial.list();
        Foout.mkdir();
        for (int i = 0; i<flists.length; i++)
        {
            copyfile(srcFolder+"/"+flists[i],destFolder+"/"+flists[i]);
        }
//        try(FileReader fr = new FileReader(Foinitial);BufferedReader br = new BufferedReader(fr);
//            FileWriter fw = new FileWriter(Foout);PrintWriter pw = new PrintWriter(fw);){
//            String line;
//            while((line = br.readLine()) != null)
//                pw.println(line);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
    public static void main(String[] args) {
        String srcFile,destFile,srcFolder,destFolder;
        srcFile = "e:/python学习/teststream.java";
        destFile = "e:/python学习/teststream_copy.java";
        srcFolder = "e:/python学习/forcopy";
        destFolder = "e:/python学习/forcopy1";
//        copyfile(srcFile,destFile);
        copyfolder(srcFolder,destFolder);
    }
}
