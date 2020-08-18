//创建一个长度是100的字符串数组
//使用长度是2的随机字符填充该字符串数组
//统计这个字符串数组里重复的字符串有多少种
package charactor1;

import java.util.Random;

public class Stringcompare {
    private static String[] Strindex;
    public static void main(String[] args) {
        Strindex = generateStr(50);
        boolean flag = false;
        for (int i=0;i<Strindex.length;i++){
            for (int j=i+1;j<Strindex.length;j++){
                if (Strindex[i].equals(Strindex[j])) {
                    System.out.println(Strindex[i]);
                    flag = true;
                }
            }
        }
        if (flag == false)
            System.out.println("无重复字符串");
    }
        public static String[] generateStr ( int snumber){
            int str_num;
            char c;
            Random rand = new Random();
            String[] str = new String[snumber];
            for (int i = 0; i < str.length; i++) {
                String temp_str = "";
                for (int j = 0; j < 2; j++) {
                    while (true) {
                        str_num = rand.nextInt(57) + 65;
                        c = (char) str_num;
                        if (Character.isDigit(c) || Character.isLetter(c)) {
                            temp_str = temp_str + c;
                            break;
                        }
                    }
                }
//                System.out.println(temp_str);
                str[i] = temp_str;
            }
//            System.out.println(str);
            return str;
        }
}
