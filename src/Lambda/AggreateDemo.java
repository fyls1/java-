package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import charactor.Heroc;

public class AggreateDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Heroc> heros = new ArrayList<Heroc>();
        for (int i = 0; i < 6; i++) {
            heros.add(new Heroc("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("遍历集合中的每个数据");
        heros
                .stream()
                .forEach(h->System.out.print(h));
        System.out.println("返回一个数组");
        Object[] hs= heros
                .stream()
                .toArray();
        System.out.println(Arrays.toString(hs));
        System.out.println("返回伤害最低的那个英雄");
        Heroc minDamageHero =
                heros
                        .stream()
                        .min((h1,h2)->h1.damage-h2.damage)
                        .get();
        System.out.print(minDamageHero);
        System.out.println("返回伤害最高的那个英雄");

        Heroc mxnDamageHero =
                heros
                        .stream()
                        .max((h1,h2)->h1.damage-h2.damage)
                        .get();
        System.out.print(mxnDamageHero);

        System.out.println("流中数据的总数");
        long count = heros
                .stream()
                .count();
        System.out.println(count);

        System.out.println("第一个英雄");
        Heroc firstHero =
                heros
                        .stream()
                        .findFirst()
                        .get();

        System.out.println(firstHero);
        System.out.println("伤害第三英雄");
        aggdemo(heros);

    }
    public static void aggdemo(List<Heroc> list){
        Heroc heros = list
                .stream()
                .sorted((h1,h2)->h1.damage<=h2.damage?1:-1)
                .limit(3)
                .min((h1,h2)->h1.damage-h2.damage)
                .get();
        System.out.println(heros);
    }
}