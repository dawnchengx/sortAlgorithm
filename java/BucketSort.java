import java.util.Collections;
import java.util.ArrayList;

class BucketSort{
    public void bucketSort(int[]arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }

        //桶数
        int bucketNum=(max-min)/arr.length+1;
        ArrayList<ArrayList<Integer>>bucketArr=new ArrayList<>(bucketNum);
        for(int i=0;i<bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i=0;i<arr.length;i++){
            int num=(arr[i]-min)/(arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        int k = 0;
        ArrayList<Integer> tempArr;
        for(int i=0;i<bucketArr.size();i++){
            Collections.sort(bucketArr.get(i));
            tempArr = bucketArr.get(i);
            for(int j=0; j< tempArr.size(); j++) {
                arr[k++] = tempArr.get(j);
            }
        }
//        System.out.println(bucketArr.toString());
    }
}
