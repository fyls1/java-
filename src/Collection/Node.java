package Collection;
import java.util.ArrayList;
import java.util.List;
import charactor.kHero;


public class Node {
    // 左子节点
    public Node leftNode;
    // 右子节点
    public Node rightNode;

    // 值
    public kHero value;

    // 插入 数据
    public void add(kHero h) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = h;

            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if (h.hp - value.hp <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(h);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(h);
            }

        }

    }

    // 中序遍历所有的节点
    public List<kHero> values() {
        List<kHero> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightNode)

            values.addAll(rightNode.values());

        return values;
    }
    public static void main(String[] args) {
        List<kHero> heros = new ArrayList<>();
        for (int i=0;i<10;i++){
            heros.add(new kHero("hero name" + i));
            heros.get(i).hp = (int) (Math.random()*1000);
            System.out.println(heros.get(i)+ " " +Float.toString(heros.get(i).hp));
        }
        Node Herotree = new Node();
        for (kHero hh:heros){
            Herotree.add(hh);
        }
        heros = Herotree.values();
        System.out.println("排序后结果");
        for (int i=0;i<10;i++) {
            System.out.println(heros.get(i)+" "+heros.get(i).hp);
        }

    }
}