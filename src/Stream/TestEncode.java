package Stream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class TestEncode {
    public static void encodeFile(File encodingFile, File encodedFile) {
        File f = encodingFile;
        File fo = encodedFile;
        try(FileReader fr = new FileReader(f);FileWriter fr1 = new FileWriter(fo)){
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            char[] edb = new char[(int) f.length()];
            int i = 0;
            String str0 = String.valueOf(all);
            System.out.println("加密前：" + str0);
            for (char b : all) {
                // 打印出来是A B
                if (Character.isDigit(b)){
                    if (b == '9'){
                        b = '0';
                    }
                    else
                        b = (char) (b+1);
                }
                else if (Character.isLetter(b)){
                    if (b == 'z' || b == 'Z'){
                        b = (char) (b - 25);
                     }
                    else{
                        b = (char) (b+1);
                    }
                }
                edb[i] = b;
                i ++;
            }
            String str1 = String.valueOf(edb);
            System.out.println("加密后：" + str1);
            fr1.write(edb,0,edb.length);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        File f1 = new File("e:/python学习/teststream.txt");
        File f2 = new File("e:/python学习/teststreamout.txt");
        encodeFile(f1,f2);
    }
}
