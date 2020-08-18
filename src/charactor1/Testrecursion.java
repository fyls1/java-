//产生3位密码并递归破解
package charactor1;
import java.util.Random;

public class Testrecursion {

    public static void main(String[] args){
        int str_num;
        char c;
        char[] password = new char[3];
        String str1;
        Random rand = new Random();
        char[] str = new char[3];
        for (int i=0;i<str.length;i++){
            str_num = rand.nextInt(25) + 97;
            c = (char) str_num;
            str[i] = c;
        }
        str1 = String.valueOf(str);
        System.out.println("密码是："+str1);
        boolean found = false;
        getPassword (str1,2, password);
    }
    static boolean found;
    public static void getPassword (String str,int deep, char[] password){
        if (found)
            return;
        for (int i=97;i<=122;i++){
            password[deep]=(char) i;
            if (deep!=0){
                getPassword(str,deep-1,password);
            }else{
                String guess = String.valueOf(password);
                if (guess.equals(str)){
                    System.out.println("找到的密码是："+guess);
                    found = true;
                    return;
                }

            }
        }
    }

}
