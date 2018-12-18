public class BubbleSort{
    public void basicBubbleSort(int[] arr) {
        int i, j, temp;
        int len = arr.length;
        for(i=0; i < len; i++) {
            for(j=len - 1; j > i; j--) {
                if(arr[j] < arr[j-1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    public void optimizeBubbleSort(int[] arr) {
        int i, j, temp;
        int len = arr.length;
        boolean didSwap;
        for(i=0; i < len; i++) {
            didSwap = false;
            for(j=len - 1; j > i; j--) {
                if(arr[j] < arr[j-1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    didSwap = true;
                }
            }
            if(!didSwap) {
                return;
            }
        }
    }
}