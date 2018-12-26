import java.util.Arrays;

public class HeapSort{
    private int heapSize;
    private int forkNum;
    public void twoHeapSort(int[] arr) {
        int i, alen, temp;
        alen = arr.length;
        heapSize = alen;
        buildTwoMaxHeap(arr);
        for(i = alen-1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            maxTwoHeapify(arr, 0);
        }
    }
    private void buildTwoMaxHeap(int[] arr){
        int i, alen;
        alen = arr.length;
        for(i=alen/2 - 1; i >= 0; i--){
            maxTwoHeapify(arr, i);
        }
    }
    private void maxTwoHeapify(int[] arr, int i){
        int l, r, largest, temp;
//        heapSize = arr.length;
        l = left(i+1) - 1;
        r = right(i+1) - 1;
        if(l < heapSize && arr[l] > arr[i]){
            largest = l;
        }else {
            largest = i;
        }
        if(r < heapSize && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxTwoHeapify(arr, largest);
        }
    }
    private int left(int i) {
        return 2*i;
    }
    private int right(int i) {
        return 2*i+1;
    }

    public void mutliHeapSort(int[] arr, int forkNum) {
        if(2 > forkNum) {
            System.out.println("该多叉树，叉数必须大于2");
            return;
        }
        this.forkNum = forkNum;
        int i, alen, temp;
        alen = arr.length;
        heapSize = alen;
        buildMutliMaxHeap(arr);
        for(i = alen-1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            maxMutliHeapify(arr, 0);
        }
    }
    private void buildMutliMaxHeap(int[] arr){
        int i, alen;
        alen = arr.length;
        for(i=alen/2 - 1 + alen%forkNum - 1; i >= 0; i--){
            maxMutliHeapify(arr, i);
        }
    }
    private void maxMutliHeapify(int[] arr, int i){
        int j, currFork, largest, temp;
        largest = i;
        for (j = 0, currFork = forkNum * (i+1) - forkNum/2 -1 ; j < forkNum; j++, currFork++ ) {
            if(currFork < heapSize && arr[currFork] > arr[largest]) {
                largest = currFork;
            }
        }
        if(largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxMutliHeapify(arr, largest);
        }
    }
}