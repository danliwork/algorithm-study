package array;

public class NewYearChaos {
    //https://www.includehelp.com/java-programs/minimum-swaps-required-to-sort-an-array.aspx


    static void minimumBribes(int[] q) {
        int bribe = 0;
        boolean chaotic = false;
        int length = q.length;
        for(int i = length -1; i >= 0; i--) {
            if(q[i] != i+1) { // q[i] = i+1 means no bribe
                if(q[i-1] == i+1){ //bribe 1 person
                    bribe++;
                    swap(q, i-1,i);
                } else if(q[i-2] == i+1){//bribe 2 person
                    bribe+=2;
                    swap(q, i-2,i-1);
                    swap(q, i-1,i);
                } else {
                    chaotic = true;
                    break;
                }
            }
        }
        if(chaotic)
            System.out.println("Too chaotic");
        else
            System.out.println(bribe);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void minimumBribes2(int[] q) {
        int length = q.length;
        int count = 0;

        for(int i=0; i<length; i++){
            int bribes = q[i] - (i+1);
            if(bribes > 2){
                System.out.println("Too chaotic");
                return;
            } else {
                count += bribes > 0 ? bribes : 0;
            }
        }
        System.out.println(count);
    }



    public static void main(String[] args) {
        int[] arr = { 1,2,5,3,7,8,4,6};
        //Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        minimumBribes(arr);
    }

}
