package Collection;
import java.util.*;

public class Listshuffle {
    public static void main(String[] args) {
        List<Integer> numlist = new ArrayList<>();
        for (int i=0;i<10;i++){
            numlist.add(i);
        }
        int count = 0;
        for(int i=0;i<10000;i++) {
            Collections.shuffle(numlist);
            if (numlist.get(0)==3 && numlist.get(1)==1 && numlist.get(2)==4){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
