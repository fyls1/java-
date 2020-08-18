package charactor1;

public class Testnumber {
    public static void main(String[] args) {
//  求自然对数
//        int n = 100000;
//        double result;
//        result = Math.pow((1 + (double)1/n),n);
//        System.out.println(result);
//  求10000000以内的质数
        boolean flag=false;
        for (int i=1;i<10000000;i=i+2 ){
            flag = false;
            for (int j=2;j<=Math.sqrt(i);j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println(i + "是质数");
            }
        }
    }
}
