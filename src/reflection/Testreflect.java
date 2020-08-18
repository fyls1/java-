package reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class Testreflect {
    public static void main(String[] args) {
//        Hero h1 = new Hero();
//        h1.name = "yase";
//        System.out.println(h1);
//        try{
//            String className = "reflection.Hero";
//            Class pClass = Class.forName(className);
//            Constructor c = pClass.getConstructor();
//            Hero h2 = (Hero) c.newInstance();
//            h2.name = "daji";
//            System.out.println(h2);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        String s = getName("E:\\python学习\\java学习\\hero.config");
        try{
            String className = s;
            Class pClass = Class.forName(className);
            Constructor c = pClass.getConstructor();
            ADHero h2 = (ADHero) c.newInstance();
            h2.name = "daji";
            System.out.println(h2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getName(String path){
        File file = new File(path);
        String s =null;
        try{BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
            s = br.readLine();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
