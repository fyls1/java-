package Collection;

import java.util.ArrayList;
import java.util.List;

public class ComNodeSort {
    // 左子节点
    public ComNodeSort leftNode;
    // 右子节点
    public ComNodeSort rightNode;

    // 值
    public Object value;

    // 插入 数据
    public void add(Object v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;

            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new ComNodeSort();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new ComNodeSort();
                rightNode.add(v);
            }

        }

    }

    // 中序遍历所有的节点
    public List<Object> values() {
        List<Object> values = new ArrayList<>();

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
    public static int[] maopao(int[] rr){
        for (int i=0;i<rr.length;i++){
            for (int j=0;j<rr.length-i-1;j++){
                if (rr[i]>rr[i+1]){
                int temp = rr[i];
                rr[i] = rr[i+1];
                rr[i+1] = temp;
                }

            }
        }
        return rr;
    }

    public static int[] xuanze(int[] rr){
        for (int i=0;i<rr.length;i++){
            for (int j=0;j<rr.length;j++){
                if (rr[i]<rr[j]){
                    int temp = rr[i];
                    rr[i] = rr[j];
                    rr[j] = temp;
                }
            }
        }
        return rr;
    }

    public static void main(String[] args) {

        int randoms[] = new int[10000];
        for (int i=0;i<randoms.length;i++){
            randoms[i] = (int) (Math.random()*10000);
        }
        long start = System.currentTimeMillis();
        System.out.println("二叉树排序法：");
        ComNodeSort roots = new ComNodeSort();
        for (int number : randoms) {
            roots.add(number);
        }
        roots.values();
        long end = System.currentTimeMillis();
        System.out.println("所用时间为：" + (end - start) + "ms");
        long start0 = System.currentTimeMillis();
        System.out.println("冒泡排序法：");
        int[] resultmaopao = maopao(randoms);
        long end0 = System.currentTimeMillis();
        System.out.println("所用时间为：" + (end0 - start0) + "ms");
        long start1 = System.currentTimeMillis();
        System.out.println("选择排序法：");
        int[] resultxuanze = xuanze(randoms);
        long end1 = System.currentTimeMillis();
        System.out.println("所用时间为：" + (end1 - start1) + "ms");
    }
}
