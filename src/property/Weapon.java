package property;

public class Weapon extends Item1 {
       int ac;

    @Override
    public boolean disposable() {
        return false;
    }

    public static void main(String[] args)
        {
            Weapon clothArmor = new Weapon();
            clothArmor.name = "布甲";
            clothArmor.price = 300;
            clothArmor.ac = 15;
            Weapon chainMail = new Weapon();
            chainMail.name = "锁子甲";
            chainMail.price = 500;
            chainMail.ac = 40;
            System.out.println(chainMail.name);
        }
    }

