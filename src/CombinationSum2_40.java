import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    int [] candidates;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = Arrays.stream(candidates).sorted().toArray();
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
            if (sum + candidates[i] > target) break;
            if(i > index && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            dfs(i + 1, combination, sum + candidates[i]);
            combination.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < candidates.length; i++){
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            ds.add(candidates[i]);
            findCombinations(i + 1, candidates, target - candidates[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,33,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,44,4,4,4,5,5,5,5,5,5,5,5,5,5,5,49,5,5,5,5,6,6,6,6};
        int target = 29;

        long startTime = System.nanoTime();
        System.out.println(new CombinationSum2_40().combinationSum2(candidates, target));
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Time in nanoseconds
        System.out.println("Execution time: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        System.out.println(new CombinationSum2_40().combinationSum2_2(candidates, target));
        endTime = System.nanoTime();
        duration = endTime - startTime; // Time in nanoseconds
        System.out.println("Execution time: " + duration + " nanoseconds");
    }
}

/*
# optimization

combinationSum2
Execution time: 8492900 nanoseconds

combinationSum2_2
Execution time: 3441600 nanoseconds
 */