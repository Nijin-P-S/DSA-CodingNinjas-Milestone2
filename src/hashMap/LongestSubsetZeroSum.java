package hashMap;

/*
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
 */

import java.util.HashMap;

public class LongestSubsetZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        //Brute-Force approach
//         int maxLength = 0, length =0;

//         for(int i=0;i<arr.length;i++){
//             int sum = arr[i];

//             for(int j=i+1; j<arr.length; j++){
//                 sum+=arr[j];
//                 if(sum == 0 && maxLength<(j-i+1))
//                     maxLength = (j-i+1);
//             }
//         }
//         return maxLength;


        int maxLength =0, length=0;
        int cumuSum = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            cumuSum += arr[i];

            if(cumuSum == 0)
            {	if(i>maxLength)
                maxLength = i+1;
            }

            else if(hashMap.get(cumuSum) != null){
                length = i - hashMap.get(cumuSum);
                if(maxLength<length)
                    maxLength = length;
            }

            else
                hashMap.put(cumuSum, i);
        }

        return maxLength;
    }
}
