package array;

import java.util.*;
import java.util.stream.IntStream;

public class MergeIntervals {


    public List<Interval> merge1(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }


    // my solution : need to add sort
    private static class Interval{
        public int start;
        public int end;

        public Interval(int[] arr){
            this.start = arr[0];
            this.end = arr[1];
        }
    }
    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Interval s = new Interval(intervals[i]);
            intervalList.add(s);
        }

        Collections.sort(intervalList, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for(Interval interval : intervalList){
            if(merged.isEmpty() || merged.getLast().end < interval.start)
                merged.add(interval);
            else{
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }

        }

        int[][] result = new int[merged.size()][2];
        IntStream.range(0, merged.size()).forEach(
                i -> result[i] = new int[]{merged.get(i).start, merged.get(i).end}
        );

        return result;

    }


    public static void main(String[] args) {
    int[][] arr = { new int[]{1,4}, new int[]{0,4}};
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        System.out.println();
        System.out.println(merge(arr));
}
}
