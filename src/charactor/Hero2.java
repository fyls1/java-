package charactor;

public class Hero2 {
    private String name;
    private int hp;
    private float armor;
    private int moveSpeed;
    static String copyright;
//    public static void main(String args[]) {
//        Hero teemo=new Hero();
//        teemo.name="提莫";
//        Hero garen=new Hero();
//        garen.name="盖伦";
//        Hero.copyright = "版权由Riot Games公司所有。";
//        teemo.copyright="Blizzard Entertainment Enterprise";
//        System.out.println(garen.copyright);
//    }
    private Hero2(){
    }
    private static Hero2 instance = new Hero2();
    private static Hero2 getInstance(){
        return instance;
    }
}

//    public Hero(String name,float hp){
//        this.name = name;
//        this.hp = hp;
//    }
//
//    //复活
//    public Hero revive(Hero h){
//        return h = new Hero("提莫",383);
//    }
//
//    public static void main(String[] args) {
//        Hero teemo =  new Hero("提莫",383);
//
//        //受到400伤害，挂了
//        teemo.hp = teemo.hp - 400;
//
//        teemo = teemo.revive(teemo);
//
//        System.out.println(teemo.hp); //输出多少？ 怎么理解？
//
//    }
//}
