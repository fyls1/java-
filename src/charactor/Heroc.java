package charactor;

public class Heroc {
    public String name;
    public float hp;

    public int damage;

    public Heroc() {

    }
    public float getHp() {
        return hp;
    }
    public static int testHp(Heroc h1,Heroc h2){
        return h1.hp >= h2.hp ? 1 : -1;
    }
    public Heroc(String name) {

        this.name = name;
    }

    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

    public Heroc(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    public boolean isDead() {
        return 0>=hp?true:false;
    }
    //回血
    public synchronized void recover(){
        hp=hp+1;
    }

    //掉血
    public void hurt(){
        synchronized(this){
        hp=hp-1;}
    }

    public void attackHero(Heroc h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

}
