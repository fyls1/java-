package multiplethread;

import charactor.Heroc;

public class Battle implements Runnable{

    private Heroc h1;
    private Heroc h2;

    public Battle(Heroc h1, Heroc h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
