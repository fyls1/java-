package charactor;

public class Hero0 {
    public String name;
    public volatile float hp;//volatile关键保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的

    public int damage;

    public synchronized void recover() {
        if (hp == 1000) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
//        this.notify();
    }

    public synchronized void hurt() {
        if (hp == 1) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }

    public void attackHero(Hero0 h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "死了！");
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

}