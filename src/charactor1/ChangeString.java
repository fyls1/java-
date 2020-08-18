//改变字符串每个单词首字母
package charactor1;

public class ChangeString {

    public static void main(String[] args) {

        String sentence = "let there be light";

        String[] stemp = sentence.split(" "); //
        for (int i=0;i<stemp.length;i++) {
            String c = stemp[i];
            char firstch = Character.toUpperCase(c.charAt(0));
            stemp[i] = Character.toString(firstch) + stemp[i].substring(1,c.length()) ;
            System.out.println(stemp[i]);

        }
    }

}
