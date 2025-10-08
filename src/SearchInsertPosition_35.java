public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int index = (int) (left + right) / 2;
            if(nums[index] == target)
                return index;

            if(nums[index] > target)
                right = index - 1;
            else
                left = index + 1;
        }
        return right + 1;
    }

    public static void main(String[] args) {


        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        SearchInsertPosition_35 searchInsertPosition35 = new SearchInsertPosition_35();
        System.out.println("resoult: " + searchInsertPosition35.searchInsert(nums, target));
    }
}
