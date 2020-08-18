package multiplethread;

import java.awt.GradientPaint;

import charactor.Hero0;

public class Testjiaohu {

    public static void main(String[] args) {

        final Hero0 gareen = new Hero0();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t4 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t4.start();
        Thread t5 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t5.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();

        Thread t3 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t3.start();


    }

}
