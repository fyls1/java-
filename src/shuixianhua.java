import java.util.HashMap;

//public class shuixianhua {
//    public static void main(String[] args) {
//        int temp1, temp2, temp3;
//        for (int i = 100; i < 1000; i++) {
//            temp1 = (int) i / 100;
//            temp2 = (int) ((i - temp1 * 100) / 10);
//            temp3 = i - 100 * temp1 - 10 * temp2;
//            if (i == Math.pow(temp1, 3) + Math.pow(temp2, 3) + Math.pow(temp3, 3))
//                System.out.println(i);
//        }
//    }
//}
class shuixianhua {
    public static int lengthOfLongestSubstring(String s) {
            HashMap<String,Integer> strindex = new HashMap<>();
            int num = -1;
            int bestnum = 0;
            for(int i=0;i<s.length();i++){
                if(strindex.containsKey(s.substring(i,i+1)) && strindex.get(s.substring(i,i+1))>num){
                    num = strindex.get(s.substring(i,i+1));
                }
                strindex.put(s.substring(i,i+1),i);
                if (i-num>bestnum)
                    bestnum = i-num;
            }
            return bestnum;
        }


    public static void main(String[] args) {
        String str ="abba";
        System.out.println(str.substring(0,1)==" ");
        int bnum = lengthOfLongestSubstring(str);
        System.out.println(bnum);
    }
}
//class Solution:
//        def lengthOfLongestSubstring(self, s: str) -> int:
//        k, res, c_dict = -1, 0, {}
//        for i, c in enumerate(s):
//            if c in c_dict and c_dict[c] > k:  # 字符c在字典中 且 上次出现的下标大于当前长度的起始下标
//                k = c_dict[c]
//                c_dict[c] = i
//            else:
//                c_dict[c] = i
//                res = max(res, i-k)
//        return res