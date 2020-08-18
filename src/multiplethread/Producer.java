package multiplethread;

public class Producer implements Runnable {
    String name;
    Mystackl mystack;
    public Producer(String name, Mystackl mystack){
        this.name = name;
        this.mystack = mystack;
    }
    public void run() {
        while (true){
            Character num = (char) ((int)(Math.random()*('Z'-'A')+'A'));
            mystack.push(num);
            System.out.println(name+"压入:"+num);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
