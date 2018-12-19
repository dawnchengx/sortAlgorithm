public class InsertionSort{
    public void basicInsertionSort(int[] arr) {
        int i, j, key;
        for(j=1; j < arr.length; j++) {
            key = arr[j];
            i = j - 1;
            while(i>=0 && arr[i] > key){
                arr[i+1] = arr[i];
                i = i - 1;
            }
            arr[i+1] = key;
        }
    }
    public void shellInsertionSort(int[] arr) {
        int increment, alen, i, j, key;
        alen = arr.length;
        increment = alen;
        do{
            increment = increment/3 + 1;
            for(j=increment;j < alen; j++) {
                key = arr[j];
                i = j - increment;
                while(0 <= i && arr[i] > key) {
                    arr[i+increment] = arr[i];
                    i = i - increment;
                }
                arr[i+increment] = key;
            }
        }while(1 < increment);
    }
}