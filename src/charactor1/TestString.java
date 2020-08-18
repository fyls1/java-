//创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
package charactor1;

import java.util.Random;

public class TestString {
    public static void main(String[] args){
        int str_num;
        char c;
        Random rand = new Random();
        char[] str = new char[5];
        for (int i=0;i<str.length;i++){
            str_num = rand.nextInt(75) + 48;
            c = (char) str_num;
            if (Character.isDigit(c)||Character.isLetter(c))
                str[i] = c;
            else
                str[i] = (char) (str_num - 7);

        }
        for (char b:str)
            System.out.println(b);
    }

}
