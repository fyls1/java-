package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 *  需求：既能往服务器发消息，又能从服务器接受到消息
 *  思路：用两个线程分别实现这两个功能
 *  注意：即使手动开启的第一个线程中有死循环，后续的线程也能得到执行机会
 *          因为主线程才是第一个线程，手动开启的第一个线程不可能独占所有时间片
 *          因此第二个线程肯定能start启动
 *
 */
public class ClientDemo1 {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO Auto-generated method stub
        Socket client = new Socket("127.0.0.1", 8888);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try (Scanner scanner = new Scanner(System.in)) {
                    try (OutputStream output = client.getOutputStream();
                         DataOutputStream dos = new DataOutputStream(output)) {
                        while (true) {
                            String nextLine = null;
                            // 如何让发送消息的线程让出时间片给读取消息的线程
                            if (null != (nextLine = scanner.nextLine())) {
                                dos.writeUTF(nextLine);
                            }
                            // 每个回合先读取控制台的输入，若没有，再读取Server端发来的消息
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try (InputStream input = client.getInputStream(); DataInputStream dis = new DataInputStream(input)) {
                    while (true) {
                        String readLine = null;
                        if (null != (readLine = dis.readUTF())) {
                            System.out.println("server: " + readLine);
                        }
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
