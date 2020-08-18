package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        System.out.println("client连过来了");

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
                            System.out.println("client: " + readLine);
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

