package array;

public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int count = 0;
        for(int col = 0; col<n; col++){
            for(int i = 1; i<strs.length-1; i++){
                if(strs[i].charAt(col) - 'a' > strs[i+1].charAt(col) - 'a'){
                    count++;
                }
            }
        }

        return count;

    }
}
