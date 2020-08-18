package multiplethread;

import java.util.ArrayList;
import java.util.List;

public class TestFindcode {
    public static String gcode(int length){
        char Randomlist[] = new char[length];
        char max = 'z'+1;
        char min = '0';
        for(int i=0;i<length;i++){
            while(true){
                char cod = (char)(Math.random() * (max - min) + min);
                if (Character.isLetterOrDigit(cod)){
                    Randomlist[i] = cod;
                    break;
                }
            }
        }
        System.out.println("随机产生的密码是"+String.valueOf(Randomlist));
        return String.valueOf(Randomlist);
    }

    public static void main(String[] args) {
        int len = 3;
        String passcode = gcode(len);
        List<String> Strvessel = new ArrayList<>();
        Thread t1 = new Thread(){
            public void run(){
                char mycode[] = new char[len];
                int flag = 0;
                for (int i='0';i<'z';i++){
                    for (int j='0';j<'z';j++){
                        for (int k='0';k<'z';k++){
                            if(Character.isLetterOrDigit(i)&&Character.isLetterOrDigit(j)&&Character.isLetterOrDigit(k)){
                                mycode[0] = (char)i;
                                mycode[1] = (char)j;
                                mycode[2] = (char)k;
                                String findcode = new String(mycode);
                                try{
                                    Thread.sleep(20);//穷举时短时间等待，给线程2输出的时间
                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                                Strvessel.add(findcode);
                                if (findcode.equals(passcode)){
                                    System.out.println("找到了密码,是"+findcode);
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                        if (flag == 1)
                            break;
                    }
                    if (flag == 1)
                        break;
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    while(Strvessel.isEmpty()){
                        try{
                            Thread.sleep(500);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    String sc = Strvessel.remove(0);
                    System.out.println("尝试了该密码"+sc);
                }
            }
        };
        t2.setDaemon(true);
        t2.start();
    }
}
