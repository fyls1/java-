package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Heroc;

public class TestAggregate {

    public static void main(String[] args) {
        Random r = new Random();
        List<Heroc> heros = new ArrayList<Heroc>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Heroc("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        //制造一个重复数据
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
        System.out.println("满足条件hp>100&&damage<50的数据");

        heros
                .stream()
                .filter(h->h.hp>100&&h.damage<50)
                .forEach(h->System.out.print(h));

        System.out.println("去除重复的数据，去除标准是看equals");
        heros
                .stream()
                .distinct()
                .forEach(h->System.out.print(h));
        System.out.println("按照血量排序");
        heros
                .stream()
                .sorted((h1,h2)->h1.hp>=h2.hp?1:-1)
                .forEach(h->System.out.print(h));

        System.out.println("保留3个");
        heros
                .stream()
                .limit(3)
                .forEach(h->System.out.print(h));

        System.out.println("忽略前3个");
        heros
                .stream()
                .skip(3)
                .forEach(h->System.out.print(h));

        System.out.println("转换为double的Stream");
        heros
                .stream()
                .mapToDouble(Heroc::getHp)
                .forEach(h->System.out.println(h));

        System.out.println("转换任意类型的Stream");
        heros
                .stream()
                .map((h)-> h.name + " - " + h.hp + " - " + h.damage)
                .forEach(h->System.out.println(h));

    }
}
