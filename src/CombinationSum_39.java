import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    int target;
    int[] candidates;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int index, List<Integer> combination, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }
        if(sum > target) return;
        for(int i=index; i<candidates.length; i++){
            combination.add(candidates[i]);
            dfs(i, combination, sum + candidates[i]);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum_39().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new CombinationSum_39().combinationSum(new int[]{2,3,5}, 8));
    }
}
