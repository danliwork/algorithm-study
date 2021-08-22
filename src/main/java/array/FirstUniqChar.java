package array;



import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

public class FirstUniqChar {
    public static int firstUniqCharOnline(String s) {
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        // Use char array for faster manipulation.
        char[] chars = s.toCharArray();
        // Create a character map using array for faster manipulation.
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            map[ch - 'a']++;
        }
        // use string order to find the first
        for (int i = 0; i < n; i++) {
            if (map[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }


    public static int firstUniqChar(String s) {
        Map<Character, Pair<Integer, Integer>> map = new LinkedHashMap<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, Pair.of(i, 1));
            } else {
                int oldCount = map.get(c).snd;
                map.put(c, Pair.of(i, oldCount+1));
            }
        }
        for(Map.Entry<Character, Pair<Integer, Integer>> entry: map.entrySet()){
            if(entry.getValue().snd == 1){
                return entry.getValue().fst;
            }
        }
        return -1;

    }

    public static int findUniqueCharStream(String s){
        return s.chars().mapToObj( i -> Character.valueOf((char)i)).
                collect(Collectors.groupingBy(identity(), LinkedHashMap::new, counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() ==1L)
                .map(entry -> entry.getKey())
                .findFirst().orElse(Character.valueOf((char)8));
    }

    public static boolean isOdd(int i){
        return (i&1) == 1;
    }

    public static void main(String [] args){
        String s = "loveleetcode";
        int out = firstUniqChar(s);
        boolean isOdd =  (3&1) == 1;
        //System.out.println(out);
        s.chars();



        //Stream.of(1,2,3,4,5,6).forEach(System.out::println); // 1,2,3,4,5,6
        //Stream.of(1,2,3,4,5,6).parallel().forEach(System.out::println); // 2,4,5,1,3,6
        //Stream.of(1,2,3,4,5,6).parallel().forEachOrdered(System.out::println); // 1,2,3,4,5,6
        //int[] nums = {1,2,3,4,5};

        //Arrays.asList(4,3,2,1).stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        ArrayList<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("a")){
                iterator.remove();
            }
        }
        System.out.println(list);

    }
}
