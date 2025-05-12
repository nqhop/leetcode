import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(target - threeSum)) threeSum = sum;

                if(sum < target) left++;
                else if(sum > target) right--;
                else return sum;
            }
        }
        return threeSum;
    }
}
