import java.util.*;

public class JumpGame2_45 {

    //work but Time Limit Exceeded
    public int jump(int[] nums) {

        nums[nums.length - 1] = 1;

        // map: index - count
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        priorityQueue.add(Map.entry(0, 0));

        while (!priorityQueue.isEmpty()){
            int index = priorityQueue.peek().getKey();
            int count = priorityQueue.poll().getValue();
            if(index == nums.length - 1) return count;
            count++;
            for(int i = nums[index]; i > 0; i--){
                if((index + i) >= nums.length || nums[index + i] == 0) continue;
                priorityQueue.add(Map.entry(index + i, count));
            }
        }
        return -1;
    }


    public int jump2(int[] nums) {
        if(nums.length == 1) return 0;
        int start = 0, end = 0, farthest = 0, jumps = 1;
        while(start < nums.length){
            farthest = Math.max(farthest, start + nums[start]);
            if(farthest >= nums.length - 1) return jumps;
            if(start == end){
                end = farthest;
                jumps++;
            }
            start++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new JumpGame2_45().jump(new int[]{2,3,1,1,4}));
//        System.out.println(new JumpGame2_45().jump(new int[]{2,3,0,1,4}));


        System.out.println(new JumpGame2_45().jump2(new int[]{2,3,1,1,4}));
//        System.out.println(new JumpGame2_45().jump2(new int[]{2,3,0,1,4}));
        // output: 13
        System.out.println(new JumpGame2_45().jump2(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));

    }
}
