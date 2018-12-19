public class SelectionSort{
    public void selectionSort(int[] arr) {
        int min, i, j, alen, temp;
        alen = arr.length;
        for(i=0; i < alen-1; i++){
            min = i;
            for(j=i+1; j < alen; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}