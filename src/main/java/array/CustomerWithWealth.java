package array;

import java.util.stream.IntStream;


public class CustomerWithWealth {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        int res = 0;
        for(int i = 0; i<accounts.length; i++){
            int sum = sum(accounts[i]);
            if(sum > max){
                max = sum;
                res = i;
            }
        }
        return res;
    }

    private int sum(int[] arr){
        //IntStream stream = Arrays.stream(arr);
        //return stream.sum();
        return IntStream.of(arr).sum();
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1,2,3},{3,2,1}};
        new CustomerWithWealth().maximumWealth(accounts);
    }

}
