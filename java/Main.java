import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void  main(String[] args){
        Main main = new Main();
        // 基础冒泡排序
//        main.testBasicBubbleSort();
        // 优化冒泡排序
        main.testOptimizeBubbleSort();
    }
    private void testOptimizeBubbleSort() {
        // 生成随机数
        int randomNum = 10000;
        Main main = new Main();
        int[][] arr = new int[100][randomNum];
        for(int i = 0; i < 100; i++) {
            arr[i] = main.produceRandomNum(randomNum);
//            System.out.println("排序前：" + Arrays.toString(arr[i]));
        }
        // 进行排序
        BubbleSort bubbleSort = new BubbleSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < 100; i++) {
            bubbleSort.optimizeBubbleSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/100;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("耗时：" + useTimeMs + "ms");
    }
    private void testBasicBubbleSort() {
        // 生成随机数
        int randomNum = 10000;
        Main main = new Main();
        int[][] arr = new int[100][randomNum];
        for(int i = 0; i < 100; i++) {
            arr[i] = main.produceRandomNum(randomNum);
//            System.out.println("排序前：" + Arrays.toString(arr[i]));
        }
        // 进行排序
        BubbleSort bubbleSort = new BubbleSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < 100; i++) {
            bubbleSort.basicBubbleSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/100;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("耗时：" + useTimeMs + "ms");
    }
    private int[] produceRandomNum(int num) {
        int values[] = new int[num];
        int temp1,temp2,temp3;
        Random r = new Random();
        //初始化数组
        for(int i = 0;i < values.length;i++){
            values[i] = i + 1;
        }

        //随机交换values.length次
        for(int i = 0;i < values.length;i++){
            temp1 = Math.abs(r.nextInt()) % (values.length-1); //随机产生一个位置
            temp2 = Math.abs(r.nextInt()) % (values.length-1); //随机产生另一个位置
            if(temp1 != temp2){
                temp3 = values[temp1];
                values[temp1] = values[temp2];
                values[temp2] = temp3;
            }
        }
        // 遍历数组并打印数据
        return values;
    }
}