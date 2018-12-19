public class HeapSort{
    public void heapSort(int[] arr) {
        int i, alen, temp, heapSize;
        alen = arr.length;
        heapSize = alen;
        buildMaxHeap(arr);
        for(i = alen; i >= 2; i--) {
            temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapSize = alen - 1;
            maxHeapify(arr, 1);
        }
    }
    private void buildMaxHeap(int[] arr){
        int i, alen, heapSize;
        alen = arr.length;
        heapSize = alen;
        for(i=alen/2; i >= 0; i--){
            maxHeapify(arr, i)
        }
    }
    private void maxHeapify(int[] arr, int i){
        int l, r, largest, heapSize, alen, temp;
        alen = arr.length;
        heapSize = alen;
        l = left(i);
        r = right(i);
        if(l <= heapSize && arr[l] > arr[i]){
            largest = 1;
        }else {
            largest = i;
        }
        if(r <= heapSize && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest);
        }
    }
    private int left(int i) {
        return 2*i;
    }
    private int right(int i) {
        return 2*i + 1;
    }
}