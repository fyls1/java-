package generic;

import java.util.ArrayList;

import learnjiekou.ADHero;
import learnjiekou.APHero;
import learnjiekou.Hero;

public class Testextends {

    public static void iterate(ArrayList< ? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }

    public static void main(String[] args) {
        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();

        iterate(hs);
        iterate(aphs);
        iterate(adhs);
    }

}