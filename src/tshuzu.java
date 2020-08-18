import java.util.Arrays;

public class tshuzu {
    public static void main(String[] args) {
        int [][] a = new int[5][5];
        int mresult = 0;
        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                a[i][j] = (int) (Math.random()*100);
            }
        }
        for (int i=0;i<5;i++){
            System.out.println(Arrays.toString(a[i]));
            for(int j=0;j<5;j++){
                if (a[i][j]>mresult)
                    mresult = a[i][j];
            }
        }
        System.out.println(mresult);
    }
}
