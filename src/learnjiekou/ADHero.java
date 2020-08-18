package learnjiekou;

public class ADHero extends Hero implements AD,Mortal{
    public ADHero(String name) {
      //  name = name1;
        super (name);
    }
    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
    public void die() {
        System.out.println("击杀了AD英雄" +name);
    }
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }
    public static void main(String[] args) {
        ADHero adHero = new ADHero("兰陵王");
        adHero.physicAttack();
        Hero h = new ADHero("凯");
        h.battleWin();
    }
}
