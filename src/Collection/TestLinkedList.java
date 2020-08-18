package Collection;

import java.util.LinkedList;

import charactor.kHero;

public class TestLinkedList {

    public static void main(String[] args) {

        //LinkedList是一个双向链表结构的list
        LinkedList<kHero> ll =new LinkedList<kHero>();

        //所以可以很方便的在头部和尾部插入数据
        //在最后插入新的英雄
        ll.addLast(new kHero("hero1"));
        ll.addLast(new kHero("hero2"));
        ll.addLast(new kHero("hero3"));
        System.out.println(ll);

        //在最前面插入新的英雄
        ll.addFirst(new kHero("heroX"));
        System.out.println(ll);

        //查看最前面的英雄
        System.out.println(ll.getFirst());
        //查看最后面的英雄
        System.out.println(ll.getLast());

        //查看不会导致英雄被删除
        System.out.println(ll);
        //取出最前面的英雄
        System.out.println(ll.removeFirst());

        //取出最后面的英雄
        System.out.println(ll.removeLast());

        //取出会导致英雄被删除
        System.out.println(ll);

    }

}
