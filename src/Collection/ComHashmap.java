package Collection;
import java.util.*;
import charactor.kHero;


public class ComHashmap {
    public static void main(String[] args) {
        List<kHero> heroes = new ArrayList<>();
        HashMap<String,List<Integer>> Maps = new HashMap<>();
        List<Integer> index = new ArrayList<>();
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();
        Myhashcode testmap = new Myhashcode();
        for (int i=0;i<1000000;i++){
            kHero temph = new kHero("hero-"+(int)(Math.random()*5000));
            heroes.add(temph);
            List<Integer> list= Maps.get(temph.name);
            List<Integer> list1 = (List<Integer>) testmap.get(temph.name);
            if(list==null){
                list = new ArrayList<>();
                Maps.put(temph.name, list);
            }
            if(list1==null){
                list1 = new ArrayList<>();
                testmap.put(temph.name, list1);
            }
            list.add(i);
            list1.add(i);
        }

//        System.out.println(heroes.get(1));
//        System.out.println(Maps.get(1));
        long start1 = System.currentTimeMillis();
        index = xunhuan(heroes);
        long end1 = System.currentTimeMillis();
        System.out.println(index);
        System.out.println("for循环花费" + (end1-start1)+"ms");
        long start2 = System.currentTimeMillis();
        index1 = hashfind(Maps);
        long end2 = System.currentTimeMillis();
        System.out.println(index1);
        System.out.println("Hashmap查找花费" + (end2-start2)+"ms");
        long start3 = System.currentTimeMillis();
        index2 = myhashfind(testmap);
        long end3 = System.currentTimeMillis();
        System.out.println(index2);
        System.out.println("myHashmap查找花费" + (end3-start3)+"ms");
    }
    public static List<Integer> xunhuan(List heroes){
        List<Integer> index = new ArrayList<>();
        for (int i=0;i<heroes.size();i++){
            //heroes.get(i)=="hero-1200"
            if (String.valueOf(heroes.get(i)).equals("hero-1200")){
                index.add(i);
            }
        }
        return index;
    }
    public static List<Integer> hashfind(HashMap<String,List<Integer>> Maps){
        List<Integer> index = new ArrayList<>();
        index =  Maps.get("hero-1200");
        return index;
    }
    public static List<Integer> myhashfind(Myhashcode testmap){
        List<Integer> index = new ArrayList<>();
        index = (List<Integer>) testmap.get("hero-1200");
        return index;
    }
}
