public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if(nums[i] <= 0)
                nums[i] = nums.length + 1;
        }

        for(int i = 0; i < nums.length; i++){
            int num = (nums[i] > 0 ? nums[i] : nums[i] * -1);
            if(num <= nums.length && num > 0 && nums[num - 1] > 0)
                nums[num - 1] *= -1;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
//        System.out.println(new FirstMissingPositive_41().firstMissingPositive(new int[]{3, 4, -1, 1, 8, -2}));
//        System.out.println(new FirstMissingPositive_41().firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(new FirstMissingPositive_41().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(new int[]{1, 1}));
    }
}
