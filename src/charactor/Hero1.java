package charactor;

public class Hero1 {
    public String name = "some hero";

    public Hero1(){
        name = "one hero";
    }
    {
        name = "the hero";
    }
    {
        System.out.println(name);
    }
    public static void main(String[] args) {
        Hero1 yase = new Hero1();
        System.out.println(yase.name);
    }
}

