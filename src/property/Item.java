package property;

public class Item implements Comparable<Item>{
    public String name;
    public int price;
    public Item(){
    }
    public Item(String name,int price){
        this.name = name;
        this.price = price;
    }
    private static Item instance;
    private static Item getInstance(){
        if (null==instance){
            instance = new Item();
        }
        return instance;
    }

    public int compareTo(Item anotherItem){
        if (price<anotherItem.price){
            return 1;
        }else{
            return -1;
        }
    }
    public String toString() {
        return "Hero [name=" + name + ", price=" + price + "]\r\n";
    }

}