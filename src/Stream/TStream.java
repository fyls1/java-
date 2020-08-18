package Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TStream {

    public static void main(String[] args) {
        //创建一个Hero[]
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
        Hero[] heros = new Hero[10];
        for (int i=0;i<heros.length;i++){
            heros[i] = new Hero();
            heros[i].name = "Hero" + String.valueOf(i);
            //System.out.println(heros[i].name);
        }
        //准备一个文件用于保存该对象
        File f =new File("e:/python学习/heros.lol");
        try(
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos =new ObjectOutputStream(fos);

        ) {for (int i=0;i<heros.length;i++)
            {
                oos.writeObject(heros[i]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try(
                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois =new ObjectInputStream(fis);
        ){
            Hero[] Heros1 = new Hero[10];
            for (int i=0;i<heros.length;i++){
                Heros1[i] = (Hero) ois.readObject();
                System.out.println(Heros1[i].name);
            }
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
