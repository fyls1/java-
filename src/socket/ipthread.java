package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ipthread{
    public static void main(String[] args) throws IOException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String headip = ip.substring(0,ip.lastIndexOf('.')+1);
        List<String> iplist = Collections.synchronizedList(new ArrayList<>());
        final CountDownLatch latch = new CountDownLatch(255);
        for (int i=0;i<255;i++){
            int j = i;
            Thread t = new Thread(){
                public void run(){
                    String item = headip + j;
                    boolean flag = false;
                    Process p = null;
                    try {
                        p = Runtime.getRuntime().exec("ping " + item);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = null;
//                    while (true) {
//                        try {
//                            if (!((line = br.readLine()) != null)) break;
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        if (line.contains("TTL")) {    //包含TTL说明可以ping通
//                            flag = true;
//                            break;
//                        }
//                    }
                    try {
                        while ((line = br.readLine()) != null){
                            if (line.contains("TTL")){
                                flag = true;
                                break;
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    if (flag){
                        iplist.add(item);
                    }
                    System.out.println("已完成ip"+item+"的测试");
                    latch.countDown();
                }
            };
            t.start();
        }
        try {
            latch.await();  //等待所有线程执行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("如下ip地址可以连接：");
        for (int i = 0; i < iplist.size(); i++) {
            System.out.println(iplist.get(i));
        }
    }
}
