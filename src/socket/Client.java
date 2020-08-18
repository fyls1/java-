package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();
            //把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
                if ("bye".equals(str)){
                    System.out.println("会话结束！");
                    break;
                }
                String msg = dis.readUTF();
                System.out.println("服务端消息:"+msg);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}