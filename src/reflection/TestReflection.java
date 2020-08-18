package reflection;

import java.lang.reflect.Field;

public class TestReflection {
    public static void main(String[] args) {
//        String className = "reflection.Hero";
//        try{
//            Class pclass1 = Class.forName(className);
//            Class pclass2 = Hero.class;
//            Class pclass3 = new Hero().getClass();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }

//        for (int i=0;i<10;i++){
//            Thread t = new Thread(){
//                public void run(){
//                    test();
//                }
//            };
//            t.start();
//        }
        Hero h = new Hero();
        h.name = "yase";
        try{
            Field f1 = h.getClass().getDeclaredField("name");
            f1.set(h,"daji");
            System.out.println(h.name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //添加synchronized后，类别锁，线程需要等待
    public synchronized static void test(){
        System.out.println("test方法启动");
        try{Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
