package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import property.Item;

public class ComparableItem {
    public static void main(String[] args) {
        Random r =new Random();
        List<Item> Items = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            //通过随机值实例化hero的hp和damage
            Items.add(new Item("Item"+ i, r.nextInt(100)));
        }

        System.out.println("初始化后的集合");
        System.out.println(Items);

        //Hero类实现了接口Comparable，即自带比较信息。
        //Collections直接进行排序，无需额外的Comparator
        Collections.sort(Items);
        System.out.println("按照价格高低排序后的集合");
        System.out.println(Items);

    }
}
