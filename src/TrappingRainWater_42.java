public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int total = 0;
        for(int i = 1; i < height.length; i++){
            if(height[i] > height[i-1]){
                int left = findLeft(height, i);
                int top = Math.min(height[i], height[left]);
                for(int j = left + 1; j < i; j++){
                    total += top - height[j];
                    height[j] = top;
                }
            }
        }
        return total;
    }

    private int findLeft(int[] height, int i) {
        int maxLeft = -1, index = i, maxIndex = -1;
        do{
            index--;
            if(height[index] < height[i] && height[index] > maxLeft){
                maxLeft = height[index];
                maxIndex = index;
            }
            else if (height[index] >= height[i])
                return index;
        }while (index > 0);
        return maxIndex;
    }





    // better performance


    public static void main(String[] args) {
//        System.out.println(new TrappingRainWater_42().trap(new int[]{4,2,0,3,2,5}));
        System.out.println(new TrappingRainWater_42().trap(new int[]{0, 1, 3, 5}));
    }
}
