package learnjiekou;

public class APHero extends Hero implements AP,Mortal{
    public APHero(String name) {
      //  name = name1;
        super(name);
    }

    public void magicAttack() {
        System.out.println("进行法术攻击");
    }
    public void die() {
        System.out.println("击杀了AP英雄" +name);
    }

    public static void main(String[] args) {
        APHero apHero = new APHero("甄姬");
        apHero.magicAttack();
    }
}
