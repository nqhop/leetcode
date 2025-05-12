import java.util.HashMap;
import java.util.Map;

public class NumEquivDominoPairs_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] domino : dominoes){
            int pair = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            map.put(pair, map.getOrDefault(pair, 0) + 1);
        }
        int count = 0;
        for(int value : map.values()){
            if(value > 1) count += value * (value - 1) / 2;
        }
        return count;
    }

}
