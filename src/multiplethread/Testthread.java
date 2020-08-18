package multiplethread;

import charactor.Heroc;

public class Testthread {

    public static void main(String[] args) {

        Heroc gareen = new Heroc();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Heroc teemo = new Heroc();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Heroc bh = new Heroc();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Heroc leesin = new Heroc();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

//        KillThread killThread1 = new KillThread(gareen,teemo);
//        killThread1.start();
//        KillThread killThread2 = new KillThread(bh,leesin);
//        killThread2.start();
        //实现Runnable接口
//        Battle battle1 = new Battle(gareen,teemo);
//        new Thread(battle1).start();
//        Battle battle2 = new Battle(bh,leesin);
//        new Thread(battle2).start();
        //匿名类
        Thread t1= new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();
    }

}