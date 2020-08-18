//堆排序
package sort;

import java.util.Arrays;

public class Heapsort {
    public static void main(String[] args) {
        int[] arr = {9,6,7,8,4,5,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 完成乱序数组 堆排序的方法
    //1. 构建大顶堆 2. 将大顶堆的值沉到数组末尾 3. 重新调整结构 继续构建 + 交换
    public static void sort(int[] arr){
        for (int i = arr.length/2-1;i>=0;i--){
            adjustsort(arr,i,arr.length);
        }
        System.out.println("构造的大顶堆");
        System.out.println(Arrays.toString(arr));
        for (int i=arr.length-1;i>0;i--){
            swap(arr,i);
            adjustsort(arr,0,i);
        }
    }

    public static void adjustsort(int[] arr,int i,int length){
        int temp = arr[i];
        //1. k = i * 2 + 1 k 是 i结点的左子结点
        // 开始调整 求出当前节点的 [左节点] 与 [右节点]
        for (int k = 2*i+1; k<length; k=2*k+1){
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];//把较大的值赋给当前结点
                i = k;//i指向k
            }
            else {
                break;
            }
        }
        arr[i] = temp;
    }
    public static void swap(int[] arr,int j){
        int temp = arr[j];
        arr[j] = arr[0];
        arr[0] = temp;
    }
}
