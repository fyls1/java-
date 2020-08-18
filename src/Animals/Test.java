package Animals;

public class Test {
    public static void main(String[] args) {
        Spider s=new Spider();
        Cat c= new Cat();
        Fish f=new Fish();
        s.eat();
        c.setName("小猫咪");
        c.play();
        c.eat();
        c.walk();
        f.setName("小金鱼");
        f.play();
        f.walk();
        f.eat();

    }
}
