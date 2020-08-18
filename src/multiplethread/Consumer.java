package multiplethread;

public class Consumer implements Runnable {
    String name;
    Mystackl mystack;
    public Consumer(String name, Mystackl mystack){
        this.name = name;
        this.mystack = mystack;
    }
    public void run() {
        while (true){
            char num = (char)mystack.pull();
            System.out.println(name+"弹出:"+num);
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
