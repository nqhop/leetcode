import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class permutation_46 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        List<List<Integer>> result = new ArrayList<>();
        recursion(list, new ArrayList<>(), result);
        return result;
    }

    public void recursion(List<Integer> list, List<Integer> rec, List<List<Integer>> result){
        if(list.isEmpty()) {
            result.add(rec);
            return;
        }
        for(int i = 0; i < list.size(); i++){
            List<Integer> next = new ArrayList<>(list);
            List<Integer> nextRec = new ArrayList<>(rec);
            next.remove(i);
            nextRec.add(list.get(i));
            recursion(next, nextRec, result);
        }
    }

    /*

    ✅ Giảm số lượng object được tạo ra
    đối với code phía trên, mỗi lần đệu quy là tạo ra 2 object mới
        List<Integer> next = new ArrayList<>(list);
        List<Integer> nextRec = new ArrayList<>(rec);
    ❌GC (Garbage Collector) làm việc rất nhiều
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> result = new ArrayList<>();
        backtrack(list, new ArrayList<>(), result);
        return result;

    }
    private void backtrack(List<Integer> list,
                           List<Integer> path,
                           List<List<Integer>> result) {

        if (list.isEmpty()) {
            result.add(new ArrayList<>(path)); // ⚠️ phải copy
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int picked = list.remove(i);   // chọn
            path.add(picked);

            backtrack(list, path, result);

            path.remove(path.size() - 1);  // undo
            list.add(i, picked);           // undo
        }
    }


    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            result.add(perm);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);        // ✅ chọn
            backtrack(nums, index + 1, result);
            swap(nums, index, i);        // ✅ undo
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        new permutation_46().permute3(arr);
    }
}
