//产生字符串并利用首字母排序
package charactor1;
import java.util.Random;

public class TestString1 {
    public static void main(String[] args){
        int snumber = 8;
        int str_num;
        char c;
        Random rand = new Random();
        String[] str = new String[snumber];
        for (int i=0;i<str.length;i++){
            String temp_str="";
            for (int j=0;j<5;j++) {
                while (true) {
                    str_num = rand.nextInt(57) + 65;
                    c = (char) str_num;
                    if (Character.isDigit(c)||Character.isLetter(c)) {
                        temp_str = temp_str + c;
                        break;
                    }
                }
            }
            System.out.println(temp_str);
            str[i] = temp_str;
        }
        System.out.println(str);
        //冒泡排序,charAt() 方法用于返回指定索引处的字符
        String string_temp;
        for (int i=0;i<str.length;i++){
            for (int j=0;j<str.length-i-1;j++){

                if (Character.toLowerCase(str[j].charAt(0)) > Character.toLowerCase(str[j+1].charAt(0)) ){
                    string_temp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = string_temp;
                }
            }
        }
        for(String aa:str)
            System.out.println(aa);
    }
}
