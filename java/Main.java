import java.util.Arrays;
import java.util.Random;

public class Main {
    private int randomNum = 5; // 随机数的数量
    private int testCount = 1; // 压测的次数
    public static void  main(String[] args){
        Main main = new Main();
        // 基础冒泡排序
//        main.testBasicBubbleSort();
        // 优化冒泡排序
//        main.testOptimizeBubbleSort();
        // 基础快速排序
//        main.testBasicQuickSort();
        // 递归版优化快速排序
//        main.testRecuOptimizeQuickSort();
        // 循环版优化快速排序
//        main.testLoopOptimizeQuickSort();
        // 基础插入排序
//        main.testInsertionSort();
        // 希尔优化插入排序
//        main.testShellInsertionSort();
        // 选择排序
//        main.testSelectionSort();
        // 二叉堆排序
//        main.testTwoHeapSort();
        // 多叉堆排序
//        main.testMutliHeapSort();
        // 归并排序
//        main.testMergeHeapSort();
        // 计数排序
//        main.testCountingSort();
        // 基数排序
         main.testBaseSort();
    }
    private void testBaseSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        BaseSort baseSort = new BaseSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            int[] tempArr = new int[randomNum];
            baseSort.baseSort(arr[i]);
            System.out.println("排序后：" + Arrays.toString(tempArr));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("计数排序耗时：" + useTimeMs + "ms");
    }
    private void testCountingSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        CountingSort countingSort = new CountingSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            int[] tempArr = new int[randomNum];
            countingSort.countingSort(arr[i], tempArr, randomNum);
//            System.out.println("排序后：" + Arrays.toString(tempArr));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("计数排序耗时：" + useTimeMs + "ms");
    }
    private void testMergeHeapSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        MergeSort mergeSort = new MergeSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            mergeSort.mergeSort(arr[i], 0, arr[i].length-1);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("归并排序耗时：" + useTimeMs + "ms");
    }
    private void testMutliHeapSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        HeapSort heapSort = new HeapSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            heapSort.mutliHeapSort(arr[i], 3);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("多叉堆排序耗时：" + useTimeMs + "ms");
    }
    private void testTwoHeapSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        HeapSort heapSort = new HeapSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            heapSort.twoHeapSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("二叉堆排序耗时：" + useTimeMs + "ms");
    }
    private void testSelectionSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        SelectionSort selectionSort = new SelectionSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            selectionSort.selectionSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("选择排序耗时：" + useTimeMs + "ms");
    }
    private void testShellInsertionSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        InsertionSort insertionSort = new InsertionSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            insertionSort.shellInsertionSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("希尔优化插入排序耗时：" + useTimeMs + "ms");
    }
    private void testInsertionSort() {
        // 生成随机数
        Main main = new Main();
        int[][] arr = main.produceRandomArr();
        // 进行排序
        InsertionSort insertionSort = new InsertionSort();
        long beginTime = System.nanoTime();
        for(int i = 0; i < main.testCount; i++) {
            insertionSort.basicInsertionSort(arr[i]);
//            System.out.println("排序后：" + Arrays.toString(arr[i]));
        }
        long useTime = (System.nanoTime() - beginTime)/main.testCount;
        double useTimeMs = (double)useTime/1000000;
        System.out.println("基础插入排序耗时：" + useTimeMs + "ms");
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
            System.out.println("排序前：" + Arrays.toString(arr[i]));
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