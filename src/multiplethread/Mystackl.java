package multiplethread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mystackl {
    LinkedList<Object> list = new LinkedList<Object>();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public Object pull(){
        if(list.size()==0){
            lock.lock();
            try{
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        try{
            lock.lock();
            condition.signalAll();
            return list.removeLast();
        } finally {
            lock.unlock();
        }
//        Object t = list.remove(list.size()-1);
    }

    public void push(Object tp){
        if(list.size()==200){
            try{
                lock.lock();
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();

            }
        }
        lock.lock();
        list.add(tp);
        condition.signalAll();
        lock.unlock();
    }
    public Object peek(){
        return list.get(0);
    }
}
