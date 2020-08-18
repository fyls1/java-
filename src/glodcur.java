
public class glodcur {
    public static void main(String[] args) {
        int tempi = 1;
        int tempj = 1;
        float tempr;
        float result = 1;
        for (int i = 1; i < 21; i++) {
            for (int j = i; j < 21; j++) {
                if ((i % 2 == 0) & (j % 2 == 0))
                    continue;
                tempr= (float) i/j;
                //System.out.println(tempr);
                if (Math.abs( tempr- 0.618) < Math.abs(result - 0.618)) {
                    tempi = i;
                    tempj = j;
                    result = (float) i / j;
                  //  System.out.println(result);
                }
            }
        }
        System.out.println(tempi);
        System.out.println(tempj);
        System.out.println(result);
    }
}