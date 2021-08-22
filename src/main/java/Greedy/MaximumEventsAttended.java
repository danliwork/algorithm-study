package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumEventsAttended {
    public int maxEvents(int[][] events) {
        //corner cases
        if (events == null || events.length == 0 || events[0].length == 0) return 0;

        //STEP1.定义贪心策略： 每次都attend deadline 最早的meeting
        //STEP2.对input按照贪心策略排序
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int res = 0;
        List<Integer> usedDays = new ArrayList<>();//用来记录用过的day,1 <= events[i][0] <= events[i][1] <= 10^5
        for (int i = 1; i <= 100000; i++) {
            usedDays.add(i);
        }

        //STEP3.按照贪心策略排序号的array 每consume一个最优element，update res
        for (int[] e : events) {
            int firstDayCanBeUsed = Collections.binarySearch(usedDays, e[0]);
            // firstDayCanBeUsed = -insertionPosition-1
            // insertionPosition = - firstDayCanBeUsed - 1 // index of the smallest ele that  > e[0]
            if (firstDayCanBeUsed < 0) {
                firstDayCanBeUsed = - firstDayCanBeUsed - 1;
            }
            if (firstDayCanBeUsed == usedDays.size() || usedDays.get(firstDayCanBeUsed) > e[1]) continue;
            usedDays.remove(firstDayCanBeUsed);
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] events = new int[][]{new int[]{1,4}, new int[]{4,4}, new int[]{2,2},new int[]{3,4}, new int[]{1,1}};
        new MaximumEventsAttended().maxEvents(events);
    }
}
