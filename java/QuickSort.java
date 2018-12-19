import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;

public class QuickSort{
    public void basicQuickSort(int[] arr, int p, int r) {
        int q;
        if(p < r) {
            q = basicPartition(arr, p, r);
            basicQuickSort(arr, p, q-1);
            basicQuickSort(arr, q+1, r);
        }
    }
    private int basicPartition(int[] arr, int p, int r) {
        int temp, j;
        int x = arr[r];
        int i = p -1;
        for(j=p; j < r; j++){
            if(arr[j]<=x) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }
    public void recuOptimizeQuickSort(int[] arr, int p, int r) {
        int q;
        if(p < r) {
            q = recuOptimizePartition(arr, p, r);
            basicQuickSort(arr, p, q-1);
            basicQuickSort(arr, q+1, r);
        }
    }
    private int recuOptimizePartition(int[] arr, int p, int r) {
        int[] rarr = random(r+1, 3);
        int r1 = rarr[0];
        int r2 = rarr[1];
        int r3 = rarr[2];
//        System.out.println(r1 + " " + r2 + " " + r3);
        int r0;
        if( (arr[r1] >= arr[r2] && arr[r1] <= arr[r3]) || (arr[r1] >= arr[r3] && arr[r1] <= arr[r2]) ) {
            r0 = r1;
        }else if( (arr[r2] >= arr[r1] && arr[r2] <= arr[r3]) || (arr[r2] >= arr[r3] && arr[r2] <= arr[r1]) ) {
            r0 = r2;
        }else if( (arr[r3] >= arr[r1] && arr[r3] <= arr[r2]) || (arr[r3] >= arr[r2] && arr[r3] <= arr[r1]) ) {
            r0 = r3;
        }else {
            r0 = r;
        }
        int temp, j;
        int x = arr[r0];
        int i = p -1;
        for(j=p; j < r; j++){
            if(arr[j]<=x) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r0];
        arr[r0] = temp;
        return i+1;
    }

    public void loopOptimizeQuickSort(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int end = arr.length - 1;
        int base;
        stack.push(start);
        stack.push(end);
        while(!stack.isEmpty()){
            end = stack.pop();
            start = stack.pop();
            if (start < end){
                // int i = start;
                base = loopOptimizePartition(arr, start, end);
                // ----右半边----
                stack.push(base+1);
                stack.push(end);
                // ----左半边----
                stack.push(start);
                stack.push(base-1);
            }
        }
    }
    private int loopOptimizePartition(int[] arr, int p, int r) {
        int[] rarr = random(r+1, 3);
        int r1 = rarr[0];
        int r2 = rarr[1];
        int r3 = rarr[2];
        int r0 = r;
        if( (arr[r1] >= arr[r2] && arr[r1] <= arr[r3]) || (arr[r1] >= arr[r3] && arr[r1] <= arr[r2]) ) {
            r0 = r1;
        }else if( (arr[r2] >= arr[r1] && arr[r2] <= arr[r3]) || (arr[r2] >= arr[r3] && arr[r2] <= arr[r1]) ) {
            r0 = r2;
        }else if( (arr[r3] >= arr[r1] && arr[r3] <= arr[r2]) || (arr[r3] >= arr[r2] && arr[r3] <= arr[r1]) ) {
            r0 = r3;
        }
        int temp, j;
        int x = arr[r0];
        int i = p -1;
        for(j=p; j < r; j++){
            if(arr[j]<=x) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r0];
        arr[r0] = temp;
        return i+1;
    }

    private int[] random(int max, int n) {
        Random rand = new Random();
//        System.out.println(min + " " + max);
        Set<Integer> set = new HashSet<Integer>();
        int[] array = new int[n];
        for (; true;) {
            // 调用Math.random()方法
            int num = rand.nextInt(max);
            if(2 == max) {
                break;
            }
            // 将不同的数存入HashSet中
            set.add(num);
            // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
            if (set.size() >= n) {
                break;
            }
        }
        int i = 0;
        for (int a : set) {
            array[i] = a;
            i++;
        }
        if(2 == max) {
            array[i] = 0;
        }
        return array;
    }
}