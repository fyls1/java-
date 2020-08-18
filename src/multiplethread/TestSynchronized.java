package multiplethread;

import java.awt.GradientPaint;

import charactor.Heroc;

public class TestSynchronized {

    public static void main(String[] args) {

        final Object someObject = new Object();

        final Heroc gareen = new Heroc();
        gareen.name = "盖伦";
        gareen.hp = 10000;

        int n = 10000;

        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){

                    //任何线程要修改hp的值，必须先占用someObject
//                    synchronized (someObject) {
//                        gareen.recover();
//                    }
                    gareen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;

        }

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                    //任何线程要修改hp的值，必须先占用someObject
//                    synchronized (someObject) {
//                        gareen.hurt();
//                    }
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n,n,gareen.hp);

    }

}
