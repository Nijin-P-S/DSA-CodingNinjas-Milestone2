package hashMap;

import java.util.HashMap;

/*
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well.
 */

public class PairSumToZero {
    public static int PairSum(int[] arr, int size) {

        int count =0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<arr.length; i++){
            if(hashMap.containsKey(arr[i])){
                int val = hashMap.get(arr[i]);
                hashMap.put(arr[i], val+1);
            }
            else
                hashMap.put(arr[i], 1);
        }

        for(int i=0;i<arr.length;i++){
            hashMap.put(arr[i], hashMap.get(arr[i])-1);
            int numToCheck = -1 * (arr[i]);

            if(hashMap.containsKey(numToCheck)){
                count+= hashMap.get(numToCheck);
            }
        }

        return count;
    }
}
