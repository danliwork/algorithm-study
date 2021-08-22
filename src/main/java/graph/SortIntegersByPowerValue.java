package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Slf4j
public class SortIntegersByPowerValue {

    public static int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)-> a[1] == b[1] ?a[0]-b[0]:a[1]-b[1]);
        for(int i = lo; i<=hi; i++){
            int powerI = getPower(i, memo);
            pq.add(new int[]{i, powerI});
        }
        int j = 1;
        while(j<k && !pq.isEmpty()){
            pq.poll();
            j++;
        }
        return pq.poll()[0];
    }

    // write getPower()
    private static int getPower(int x, Map<Integer, Integer> memo){
        if(x == 1) return 0;

        if(memo.containsKey(x)){
            return memo.get(x);
        }
        int res = 1;
        if(x%2 ==0){
            res += getPower(x/2, memo);
        } else {
            res += getPower(3*x + 1, memo); // should I use res + ?
        }
        memo.put(x, res);
        return res;
    }

    public static void main(String[] args) {

        int res = SortIntegersByPowerValue.getKth(7,11,4);
        log.info("RES = " + res);
    }
}
