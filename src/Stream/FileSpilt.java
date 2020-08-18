package Stream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSpilt {
    public static void main(String args[]) throws Exception
    {
        int numf;
        int flen;
        File f = new File("e:/python学习/testspilt.txt");
        //创建基于文件的输入流
        FileInputStream fis =new FileInputStream(f);
        //创建字节数组，其长度就是文件的长度
        flen = (int) f.length()%102400;
        byte[] all =new byte[(int) f.length()];
        //以字节流的形式读取文件所有内容
        fis.read(all);
        numf = (int) f.length()/102400 + 1;
        try{
            for (int i = 0; i < numf; i++) {
                FileOutputStream fos = new FileOutputStream("e:/python学习/testspilt " + i + ".txt");
                if (i == numf - 1) {
                    fos.write(all, i * 102400 + 1, flen-1);
                    System.out.println("okkk");
                } else {
                    fos.write(all, i * 102400 + 1, 102400);
                }
                fos.close();
            }
        }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }
}
