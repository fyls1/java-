package charactor;

public class Hero{
    public String name; //名字
    public float hp;    //血量
    float armor;    //护甲
    int moveSpeed;  //移动速度

    //有参的构造方法
    //默认的无参的构造方法就失效了

    public Hero(String heroName,float heroHP,float heroArmor,int heroMoveSpeed) {
        name=heroName;
        hp=heroHP;
        armor=heroArmor;
        moveSpeed=heroMoveSpeed;
    }
    public static void main(String[] args) {
        Hero garen =  new Hero("盖伦",555,40,345);
        System.out.println(garen.name+"\r"+garen.hp+"\r"+garen.armor+"\r"+garen.moveSpeed);

        // Hero teemo =  new Hero(); //无参的构造方法“木有了”
    }

}
