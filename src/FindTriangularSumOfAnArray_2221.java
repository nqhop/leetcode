public class FindTriangularSumOfAnArray_2221 {
    public int triangularSum(int[] nums) {

        if (nums.length == 1)
            return nums[0];
        int[] temp = new int[nums.length - 1];
        for(int i = 0; i < temp.length; i++){
            temp[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum(temp);
    }

    public int triangularSum2(int[] nums) {
        int n = nums.length;
        while (n > 1){
            for(int i = 0; i < n - 1; i++){
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new FindTriangularSumOfAnArray_2221().triangularSum2(new int[] {1,2,3,4,5}));;
    }
}
