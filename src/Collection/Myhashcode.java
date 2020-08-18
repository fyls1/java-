package Collection;

import java.util.LinkedList;

public class Myhashcode implements IHashMap{
    LinkedList<Entry>[] MyHashmaps= new LinkedList[2000];
    public static char[] random(int index) {
        char[] random = new char[index];
        for(int i=0; i<random.length; i++) {
            char ran = (char) ((Math.random()*64)+62);
            random[i] = ran;
        }
        return random;
    }

    public static void main(String[] args) {
        Myhashcode test= new Myhashcode();
        for (int i=0; i<100; i++ ) {
            char[] ran  = random((int)(Math.random()*8)+2);
//            System.out.print(String.valueOf(ran) + "\t" + +hashcode(String.valueOf(ran)) + "\n" );
            test.put(String.valueOf(ran),i);
            System.out.println(test.get(String.valueOf(ran)));
        }
    }

    public static int hashcode(String str) {
        int numbers = 0;
        char [] val = str.toCharArray();

        if (str.length() == 0 ) {
            return 0;
        }
        else
            for (int i=0; i<val.length; i++) {
                numbers = 23 * numbers + val[i];
                if (numbers > 1999) {
                    numbers%=2000;
                }
                if (numbers < 0) {
                    Math.abs(numbers);
                }
            }
        return numbers;
    }

    @Override
    public void put(String key, Object object) {
        int index = hashcode(key);
        Entry tentry = new Entry(key,object);
        if (MyHashmaps[index] == null){
            MyHashmaps[index] = new LinkedList<Entry>();
        }
        MyHashmaps[index].add(tentry);
    }

    @Override
    public Object get(String key) {
        int index = hashcode(key);
        if (MyHashmaps[index] == null){
            return null;
        }
        else{
            for (Entry temp:MyHashmaps[index]){
                if (temp.key.equals(key)){
                    return temp.value;
                }
            }
        return null;
        }
    }
}
