package hashMap;

/*
You are given an array of integers that contain numbers in random order.
Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
 */

import java.util.HashMap;

public class MaximumFrequencyNumber {
    public static int maxFrequencyNumber(int[] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;
        int max = 0;

        for(int i=arr.length-1; i>=0; i--){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
                if(hashMap.get(arr[i]) >= max){
                    max = hashMap.get(arr[i]);
                    result = arr[i];
                }
            }
            else{
                hashMap.put(arr[i],1);
                if(hashMap.get(arr[i]) >= max){
                    max = hashMap.get(arr[i]);
                    result = arr[i];
                }
            }
        }
        return result;
    }
}
