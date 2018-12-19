public class HeapSort{
    public void heapSort(int[] arr) {
        int i, alen, temp, heapSize;
        alen = arr.length;
        heapSize = alen;
        buildMinHeap(arr);
        for(i = alen-1; i >= 0; i--) {
            temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapSize--;
            minHeapify(arr, 1);
        }
    }
    private void buildMinHeap(int[] arr){
        int i, alen;
        alen = arr.length;
        for(i=alen/2; i >= 0; i--){
            minHeapify(arr, i);
        }
    }
    private void minHeapify(int[] arr, int i){
        int l, r, largest, heapSize, temp;
        heapSize = arr.length;
        l = left(i);
        r = right(i);
        if(l < heapSize && arr[l] < arr[i]){
            largest = l;
        }else {
            largest = i;
        }
        if(r < heapSize && arr[r] < arr[largest]){
            largest = r;
        }
        if(largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            minHeapify(arr, largest);
        }
    }
    private int left(int i) {
        return 2*i;
    }
    private int right(int i) {
        return 2*i + 1;
    }
}