import java.util.*;
import java.util.stream.Collectors;


public class permutation2_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, result);
        return result;
    }
    private void backTrack(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> perm = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            result.add(perm);
            System.out.println(perm);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            swap(nums, i, index);
            backTrack(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tem = nums[a];
        nums[a] = nums[b];
        nums[b] = tem;
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited,
                           List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, visited, current, result);

            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1};
        new permutation2_47().permuteUnique(arr);
    }
}
