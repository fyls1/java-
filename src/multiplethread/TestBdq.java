package multiplethread;

public class TestBdq {

    public static void main(String[] args) {

        Thread t1= new Thread(){
            public void run(){
                while(true){
                    for(int i=0;i<3;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("波动拳第%d发%n", i+1);
                }
                    System.out.println("开始5s的充能");
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
    }
}
