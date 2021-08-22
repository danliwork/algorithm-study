package array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/*
Find the difference between two arrays:
Two unsorted arrays are given, and you need to find (arr1 – arr2) and (arr2 – arr1).
The difference between the two arrays is defined as
all the elements from the first array which are not present in the second array,
taking the number of occurrences into consideration.
Example:
arr1: [3, 5, 2, 7, 4, 2, 7] arr2: [1, 7, 5, 2, 2, 9]
arr1 – arr2 = [3, 7, 4]
arr2 – arr1 = [1, 9]

 */
@Slf4j
public class DifferenceBetween2Arrays {

    public static int[] differenceOfTwoArrays(int[] a1, int[] a2){
        if(a1 == null && a2 == null){
            return new int[0];
        }
        if(a1 == null) return a2;
        if(a2 == null) return a1;

        Map<Integer, Integer> map1 = new LinkedHashMap<>();
        for(int n : a1){
            if(map1.containsKey(n)){
                map1.put(n, map1.get(n) + 1);
            } else {
                map1.put(n, 1);
            }
        }
        for(int n : a2){
            if(map1.containsKey(n)){
                map1.put(n, map1.get(n) - 1);
            }
        }
        List<Integer> list = new ArrayList();
        map1.entrySet().stream().filter(e -> e.getValue() > 0).forEach(entry ->{
            int count = entry.getValue();
            while(count > 0){
                list.add(entry.getKey());
                count--;
            }
        });
        //!!! list.toArray(new Foo[list.size()])  -> only works for objects. not primary types
        int[] res = new int[list.size()];
        IntStream.range(0,list.size()).forEach(i -> {
            res[i] = list.get(i);
        });
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 2, 7, 4, 2, 7};
        int[] arr2 = {1, 7, 5, 2, 2, 9};
        log.info("arr1=arr2 is {}", differenceOfTwoArrays(arr1, arr2));
        log.info("arr2=arr1 is {}", differenceOfTwoArrays(arr2, arr1));
    }


}
