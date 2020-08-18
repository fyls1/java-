package Collection;
import java.util.*;

public class LinkedHashSetPi {
    public static void main(String[] args) {
        LinkedHashSet<Integer> Plist = new LinkedHashSet<>();
        double pi = Math.PI;
        while (Plist.size()<10){
            Plist.add((int)(pi%10));
            pi = pi*10;
        }
        System.out.println(Plist);
    }
}
