package charactor;

public class kHero {
    public String name;
    public float hp;

    public int damage;

    public kHero() {

    }

    // 增加一个初始化name的构造方法
    public kHero(String name,float hp,int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public kHero(String s) {
    }

    // 重写toString方法
    public String toString() {
        return name;
    }

}