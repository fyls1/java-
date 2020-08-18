package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);

            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            //把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while (true){
            //使用readUTF读取字符串
                String msg = dis.readUTF();
                System.out.println("客户端消息：" + msg);
                if ("bye".equals(msg)){
                    break;
                }
//                Scanner sc = new Scanner(System.in);
//                String str = sc.next();
                String str = search(msg);
                dos.writeUTF(str);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static String search(String str){
        String response = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "12345678");
            Statement s = c.createStatement();){
            String sql = "select *from robot where receive= '" + str + "'";
            ResultSet rs = s.executeQuery(sql);
            List<String> responselist = new ArrayList<>();
            while (rs.next()){
                responselist.add(rs.getString("response"));
            }
            if (responselist.size()>1){
                int index = new Random().nextInt(responselist.size());
                response = responselist.get(index);
            }else if (responselist.size()<1){
                response = "找不到回答";
            }else{
                response = responselist.get(0);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return response;
    }
}