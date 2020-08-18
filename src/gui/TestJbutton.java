package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.*;

public class TestJbutton {
    static int x = 200;
    static int y = 200;
    public static void main(String[] args) {
        // 主窗体
        JFrame f = new JFrame("LoL");
        //多线程
        File file = new File("./location.txt");
        Thread t = new Thread(){
            public void run(){
                while(true){
                    int x = f.getX();
                    int y = f.getY();
                    try(FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(file);){
                        pw.println(x);
                        pw.flush();
                        pw.println(y);
                        pw.flush();
                        Thread.sleep(100);
                    }catch (IOException | InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);) {
            if (0 != file.length()) {
                x = Integer.parseInt(br.readLine());
                y = Integer.parseInt(br.readLine());
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
        // 主窗体设置大小
        f.setSize(400, 300);

        // 主窗体设置位置
        f.setLocation(x, y);

        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);

        // 按钮组件
        JButton b = new JButton("一键拆塔");

        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);

        // 把按钮加入到主窗体中
        f.add(b);

        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);

    }
}
