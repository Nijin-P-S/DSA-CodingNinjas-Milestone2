package hashMap;

/*
You are given an array of unique integers that contain numbers in random order.
You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains starting and ending element.
If the length of the longest possible sequence is one, then the output array must contain only single element.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        if(arr.length==0)
            return null;
        if(arr.length == 1){
            result.add(arr[0]);
            return result;
        }


        int start =0, end =0, pointer1=0, pointer2=0, max =0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            hashMap.put(arr[i],1);
        }

        for(int i=0;i<arr.length;i++){
            int count =0;
            pointer1 = arr[i];
            pointer2=pointer1;

            while(hashMap.get(pointer2)!=null){
                count++;
                if(max<count){
                    start = pointer1;
                    end = pointer2;
                    max = count;
                }
                pointer2++;
            }
        }

        result.add(start);
        result.add(end);
        return result;
    }
}
