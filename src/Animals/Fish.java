//1. 创建Fish类，它继承Animal类
//2. 重写Animal的walk方法以表明鱼不能走且没有腿。
//3. 实现Pet接口
//4. 无参构造方法
//5. 提供一个private 的name属性
package Animals;

public class Fish extends Animal implements Pet{
    private String name;
    public Fish(){
        super(0);
    }
    @Override
    public void walk() {
        System.out.println("鱼不能走也没有腿");
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name+"在吃东西");
    }
    public void play() {
        System.out.println(this.name+"在玩耍");
    }
}
