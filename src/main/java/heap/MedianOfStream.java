package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianOfStream{
        void add(int a, PriorityQueue<Integer> lo, PriorityQueue<Integer> hi){
            //add
            if(lo.isEmpty()){
                lo.add(a);
            } else if(hi.isEmpty()){
                hi.add(a);
            } else if(a <= lo.peek()){
                lo.add(a);
            } else if(a > lo.peek()){
                hi.add(a);
            }

            //balance
            if(lo.size() - hi.size() > 1){
                hi.add(lo.poll());
            } else if(hi.size() - lo.size() > 1){
                lo.add(hi.poll());
            }
        }

        int getMedian(PriorityQueue<Integer> lo, PriorityQueue<Integer> hi){
            if(lo.size() == hi.size()){
                return (lo.peek() + hi.peek()) /2;
            }
            if(lo.size() > hi.size())
                return lo.peek();
            return hi.peek();
        }

        int[] findMedian(int[] arr) {
            // Write your code here
            if(arr == null || arr.length == 0) return new int[0];

            PriorityQueue<Integer> lo = new PriorityQueue<>((a,b) -> b-a);
            PriorityQueue<Integer> hi = new PriorityQueue<>();

            int[] res = new int[arr.length];
            for(int i = 0; i<arr.length; i++){
                add(arr[i], lo, hi);
                res[i] = getMedian(lo, hi);
            }
            return res;
        }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 1, 5, 3};
        int[]  res = new MedianOfStream().findMedian(arr);

        System.out.println(Arrays.toString(res));



    }

}
