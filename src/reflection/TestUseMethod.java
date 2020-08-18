package reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestUseMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        String path = "E:\\python学习\\java学习\\hero.config";
        List<String> list = new ArrayList<>();
        File f = new File(path);
        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)) {
            while (true){
                String str = br.readLine();
                if (null == str){
                    break;
                }
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String classname1 = list.get(0);
            String classname2 = list.get(2);
            Class<?> pclass1 = Class.forName(classname1);
            Constructor<?> c1 = pclass1.getConstructor();
            Hero h1 = (Hero) c1.newInstance();
            h1.name = list.get(1);
            Class<?> pclass2 = Class.forName(classname2);
            Constructor<?> c2 = pclass2.getConstructor();
            Hero h2 = (Hero) c2.newInstance();
            h2.name = "daji";
            Method m = pclass1.getMethod("attackHero",Hero.class);
            m.invoke(h1,h2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
