import java.util.Arrays;
import java.util.Random;

public class Main {
    private int randomNum = 10000; // 随机数的数量
    private int testCount = 100; // 压测的次数
    public static void  main(String[] args){
        Main main = new Main();
        // 基础冒泡排序
        main.testBasicBubbleSort();
        // 优化冒泡排序
        main.testOptimizeBubbleSort();
        // 基础快速排序
        main.testBasicQuickSort();
        // 递归版优化快速排序
        main.testRecuOptimizeQuickSort();
        // 循环版优化快速排序
        main.testLoopOptimizeQuickSort();
    }
    private void testLoopOptimizeQuickSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        QuickSort quickSort = new QuickSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            quickSort.loopOptimizeQuickSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("循环版优化快速排序耗时：" + useTimeMs + "ms");
    }
    private void testRecuOptimizeQuickSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        QuickSort quickSort = new QuickSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            quickSort.recuOptimizeQuickSort(arr[i], 0, main.randomNum-1);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("递归版优化快速排序耗时：" + useTimeMs + "ms");
    }
    private void testBasicQuickSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        QuickSort quickSort = new QuickSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            quickSort.basicQuickSort(arr[i], 0, main.randomNum-1);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("基础快速排序耗时：" + useTimeMs + "ms");
    }
    private void testOptimizeBubbleSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        BubbleSort bubbleSort = new BubbleSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            bubbleSort.optimizeBubbleSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("优化冒泡排序耗时：" + useTimeMs + "ms");
    }
    private void testBasicBubbleSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        BubbleSort bubbleSort = new BubbleSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            bubbleSort.basicBubbleSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("基础冒泡排序耗时：" + useTimeMs + "ms");
    }
    private int[][]  produceRandomArr() {
        Main main = new Main();
        int randomNum = main.randomNum;
        int[][] arr = new int[main.testCount][randomNum];
        for(int i = 0; i < main.testCount; i++) {
            arr[i] = main.produceRandomNum(randomNum);
//            System.out.println("排序前：" + Arrays.toString(arr[i]));
        }
        return arr;
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