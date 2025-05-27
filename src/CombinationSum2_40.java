import java.util.ArrayList;
import java.util.List;

public class CombinationSum2_40 {
    int [] candidates;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        res = new ArrayList<List<Integer>>();
        dfs(0, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int index, List<Integer> combination, int sum){
        if(sum == target){
            res.add(new ArrayList<>(combination));
            return;
        }
        if(sum > target || index == candidates.length) return;
        for(int i = index; i < candidates.length; i++){
            combination.add(candidates[i]);
            dfs(i + 1, combination, sum + candidates[i]);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2_40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}

