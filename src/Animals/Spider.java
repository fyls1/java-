//1. Spider继承Animal类。
//2. 定义默认构造器，它调用父类构造器来指明所有蜘蛛都是8条腿。
//3. 实现eat方法
package Animals;

public class Spider extends Animal {
    public Spider(){
        super(8);
    }
    @Override
    public void eat() {
        System.out.println("蜘蛛吃东西");
    }
}
