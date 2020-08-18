package learnjiekou;
import property.Item2;
import property.LifePotion;
import property.MagicPotion;

public class Hero {
    public String name;
    float hp;
    public Hero(String name){
        this.name = name;
    }
    public void useItem(Item2 i){
        i.effect();
    }
    public void kill(Mortal m){
        m.die();
    }
    public static void battleWin(){
        System.out.println("hero battle win");
    }
    public static void main(String[] args) {

        Hero garen =  new Hero("盖伦");
      //  garen.name = ;

        ADHero lanlw = new ADHero("兰陵王");

        APHero zhenji = new APHero("甄姬");

        garen.kill(lanlw);
        garen.kill(zhenji);
//        LifePotion lp =new LifePotion();
//        MagicPotion mp =new MagicPotion();
//
//        garen.useItem(lp);
//        garen.useItem(mp);

    }
}
