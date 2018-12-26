import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;

public class CountingSort{
    public void countingSort(int[] arr, int[] outArr, int max) {
        int i, j, alen;
        alen = arr.length;
        int[] tempArr = new int[max+1];
        for(j=0; j< alen; j++) {
            tempArr[arr[j]]++;
        }
        for(i=1; i <= max; i++) {
            tempArr[i] += tempArr[i-1];
        }
        for(j = alen -1;j >= 0; j--) {
//            System.out.println(j);
//            System.out.println(arr[j]);
//            System.out.println(tempArr[arr[j]]);
            outArr[tempArr[arr[j]]-1] = arr[j];
            tempArr[arr[j]]--;
        }
    }
}