import java.util.Arrays;
/**
 * 队列结构
 * @author Fairy2016
 *
 */
class Queue {
    int data[];
    int front;
    int rear;
}
/**
 * 基数排序
 * @author Fairy2016
 *
 */
public class BaseSort {

    public void baseSort(int arr[]) {
        int alen = arr.length;
        //求最大位数
        int count = getNumberCount(getMax(arr, alen));
        //十个队列，分别存储数位数值为0-9的元素
        Queue [] queues = new Queue[10];
        //各队列初始化
        for(int i = 0; i < 10; i++) {
            queues[i] = new Queue();
            queues[i].data = new int[alen];
            queues[i].front = queues[i].rear = -1;
        }
        int m = 1;//m控制取第几位（从个位开始取直到count）
        while(count > 0) {
            for(int i = 0; i < alen; i++) {
                int place = arr[i] / m % 10;
                //根据数值分配入队
                queues[place].data[++queues[place].rear] = arr[i];
            }
            //从队号0-9顺序出队收集元素
            int s = 0;
            for(int j = 0; j < 10; j++) {
                while(queues[j].front != queues[j].rear) {
                    arr[s++] = queues[j].data[++queues[j].front];
                }
                //收集后队列清空，方便下一趟排序
                queues[j].front = queues[j].rear = -1;
            }
            m *= 10;
            count--;
        }
    }
    /**
     * 筛选出最大元素方便确定位数
     * @param a
     * @param n
     * @return
     */
    private int getMax(int a[], int alen) {
        int max = a[0];
        for(int i = 1; i < alen; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    /**
     * 求排序元素的最大位数
     * @param t
     * @return
     */
    private int getNumberCount(int placeCount) {
        int count = 0;
        while(placeCount != 0) {
            count++;
            placeCount /= 10;
        }
        return count;
    }
}