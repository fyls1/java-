
package property;

public abstract class Item1 {
    String name;
    int price;

    public abstract boolean disposable();//是否是一次性的判断类型抽象方法

    public static void main(String[] args) {
//        LifePotion lp = new LifePotion();
//        Weapon wp = new Weapon();
//        Armor ar = new Armor();
//
//        System.out.println(lp.disposable());
//        System.out.println(wp.disposable());
//        System.out.println(ar.disposable());
        Item1 i = new Item1() {           //创建匿名类对象
            public boolean disposable() {   //重写提供外部类的方法
                name = "血瓶";
                System.out.printf("%s是一次性的吗？答案：",name);
                return true;
            }
        };
        System.out.println(i.disposable());
    }
}
