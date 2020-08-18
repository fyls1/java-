package property;

public class LifePotion extends Item1 {
    public void effect(){
        System.out.println("血瓶使用后，可以回血");
    }

    @Override
    public boolean disposable() {
        return true;
    }
}
