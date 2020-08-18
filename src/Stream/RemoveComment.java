package Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RemoveComment {
    public static void removecmt(File javafile){
        File f = javafile;
        StringBuilder code = new StringBuilder(1000);
        try(FileReader fr = new FileReader(f);BufferedReader br = new BufferedReader(fr)){
            int i = 0;
            while(true){
                String line = br.readLine();
                if (line == null){
                    break;
                }
                if (line.indexOf("//") > 0)
                    continue;
                code.append(line);
                code.append("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(f);
        // 缓存流必须建立在一个存在的流的基础上
        PrintWriter pw = new PrintWriter(fw);) {
            pw.println(code.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
            File f1 = new File("e:/python学习/teststream.java");
            removecmt(f1);
        }
}
