package property;

public class Item2 {
    String name;
    int price;

    public void buy(){
        System.out.println("购买");
    }
    public void effect() {
        System.out.println("物品使用后，可以有效果 ");
    }

    public static void main(String[] args) {
//        Item2 i1= new LifePotion();
        Item2 i2 = new MagicPotion();
        System.out.print("i1  是Item类型，执行effect打印:");
//        i1.effect();
        System.out.print("i2也是Item类型，执行effect打印:");
        i2.effect();
    }

}
