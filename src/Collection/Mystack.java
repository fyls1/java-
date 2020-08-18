package Collection;
import java.util.*;
import charactor.kHero;
//线程安全的mystack
public class Mystack implements Stack{
    private static LinkedList<kHero> ll1 = new LinkedList<>();
    LinkedList<kHero> ll = (LinkedList<kHero>)Collections.synchronizedList(ll1);
    public synchronized void push(kHero h) {
        ll.addLast(h);
    }

    public synchronized kHero pull() {
        return ll.removeLast();
    }

    public synchronized kHero peek() {
        return ll.getLast();
    }
    public static void main(String[] args) {
        Mystack tstack = new Mystack();
        tstack.push(new kHero("yase"));
        tstack.push(new kHero("kai"));
        tstack.push(new kHero("ake"));
        System.out.println(tstack.pull());
        System.out.println(tstack.peek());
    }
}