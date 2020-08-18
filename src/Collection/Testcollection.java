package Collection;
import charactor.kHero;
import java.util.ArrayList;

public class Testcollection {
    public static void main(String[] args) {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new kHero("hero " + i));
        }
        kHero specialHero = new kHero("special hero");
        heros.add(specialHero);
        System.out.println(heros);
        // 判断一个对象是否在容器中
        // 判断标准： 是否是同一个对象，而不是name是否相同
        System.out.print("虽然一个新的对象名字也叫 hero 1，但是contains的返回是:");
        System.out.println(heros.contains(new kHero("hero 1")));
        System.out.print("而对specialHero的判断，contains的返回是:");
        System.out.println(heros.contains(specialHero));
        heros.set(5, new kHero("hero 5_new"));
        System.out.println(heros.get(5));
    }

}
