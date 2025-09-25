import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }

        if (i == 0){
            Arrays.sort(nums);
            return;
        }

        int minIndex = i;
        for (int j = i + 1; j < nums.length; j++){
            if(nums[minIndex] > nums[j] && nums[j] > nums[i - 1]) minIndex = j;
        }

        int tem = nums[i-1];
        nums[i-1] = nums[minIndex];
        nums[minIndex] = tem;

        Arrays.sort(nums, i, nums.length);
    }

    public static void main(String[] args) {
//        new NextPermutation_31().nextPermutation(new int[]{1, 2, 3});
//        new NextPermutation_31().nextPermutation(new int[]{1, 3, 2});
        new NextPermutation_31().nextPermutation(new int[]{5, 1, 1});
//        new NextPermutation_31().nextPermutation(new int[]{1, 2, 3 ,6, 5, 4});
    }
}
