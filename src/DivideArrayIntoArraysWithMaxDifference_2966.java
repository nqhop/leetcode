import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference_2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length / 3][3];
        for(int i=2; i<nums.length; i += 3){
            if(nums[i] - nums[i-1] > k || nums[i] - nums[i-2] > k || nums[i-1] - nums[i-2] > k) return new int[][] {};
            else {
                res[i/3][2] = nums[i];
                res[i/3][1] = nums[i-1];
                res[i/3][0] = nums[i-2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,8,7,9,3,5,1};
        int k = 2;
        DivideArrayIntoArraysWithMaxDifference_2966 d = new DivideArrayIntoArraysWithMaxDifference_2966();
        int[][] res = d.divideArray(nums, k);
    }
}
