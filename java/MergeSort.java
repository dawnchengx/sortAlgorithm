import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;

public class MergeSort{
    public void mergeSort(int[] arr, int left, int right) {
        int mid;
        if(left < right) {
            mid = (left + right) /2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    private void merge(int[] arr, int left, int mid, int right) {
        int i, j, k;
        int[] leftArr = new int[mid - left + 1 + 1];
        int[] rightArr = new int[right - mid + 1];
        for(i = 0; i < mid - left + 1; i++) {
            leftArr[i] = arr[i + left];
        }
        for(i = 0; i < right - mid; i++) {
            rightArr[i] = arr[i + mid + 1];
        }
        leftArr[mid - left+1] = 2147483647;
        rightArr[right - mid] = 2147483647;
        for(i = 0, j = 0, k = left; k <= right; k++) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }else {
                arr[k] = rightArr[j];
                j++;
            }
        }
    }
}