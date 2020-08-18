package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import charactor.kHero;

public class TestIterator {

    public static void main(String[] args) {
        List<kHero> heros = new ArrayList<kHero>();

        //放5个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heros.add(new kHero("hero name " +i));
        }

        //第二种遍历，使用迭代器
        System.out.println("--------使用while的iterator-------");
        Iterator<kHero> it= heros.iterator();
        //从最开始的位置判断"下一个"位置是否有数据
        //如果有就通过next取出来，并且把指针向下移动
        //直到"下一个"位置没有数据
        while(it.hasNext()){
            kHero h = it.next();
            System.out.println(h);
        }
        //迭代器的for写法
        System.out.println("--------使用for的iterator-------");
        for (Iterator<kHero> iterator = heros.iterator(); iterator.hasNext();) {
            kHero hero = (kHero) iterator.next();
            System.out.println(hero);
        }

    }

}
