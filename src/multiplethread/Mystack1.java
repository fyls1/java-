package multiplethread;

import java.util.LinkedList;
import java.util.List;

public class Mystack1 {
    List<Object> list = new LinkedList<Object>();
    public synchronized Object pull(){
        if(list.size()==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return list.remove(list.size()-1);
    }
    public synchronized void push(Object tp){
        if(list.size()==200){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();
        list.add(tp);
    }
    public synchronized Object peek(){
        return list.get(0);
    }
}
