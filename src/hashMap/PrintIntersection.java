package hashMap;

/*
You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively.
You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists
contain a particular value or to put it in other words,
when there is a common value that exists in both the arrays/lists.
 */

import java.util.HashMap;

public class PrintIntersection {
    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            if(hashMap.get(arr1[i]) == null)
                hashMap.put(arr1[i],1);
            else
                hashMap.put(arr1[i], hashMap.get(arr1[i])+1);
        }

        for(int i=0;i<arr2.length;i++){
            if(hashMap.get(arr2[i])!=null && hashMap.get(arr2[i])!=0 && hashMap.get(arr2[i])>0)
            {
                System.out.println(arr2[i]);
                hashMap.put(arr2[i], hashMap.get(arr2[i])-1);
            }
        }
    }

}
