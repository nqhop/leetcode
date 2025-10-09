import java.util.Random;

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
    public int trap2(int[] height) {
        int max = -1, maxIndex = 0, total = 0;
        for(int i = 0; i< height.length; i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        int maxLeft = -1;
        for(int i = 0; i < maxIndex; i++){
            if(height[i] > maxLeft){
                maxLeft = height[i];
            } else if (maxLeft > height[i]) {
                total += maxLeft - height[i];
            }
        }

        int maxRight = 0;
        for(int i = height.length - 1; i > maxIndex; i--){
            if(height[i] > maxRight)
                maxRight = height[i];
            else if (maxRight > height[i])
                total += maxRight - height[i];
        }

        return total;
    }

    public static int[] ramdomArray(int n){
        Random rand = new Random();
        int[] radomArr = new int[n];
        for(int i = 0; i < n; i++){
            radomArr[i] = rand.nextInt(400);
        }
        return radomArr;
    }


    public static void main(String[] args) {
        int[] arr = ramdomArray(5000);

        long startTime = System.nanoTime();
        System.out.println(new TrappingRainWater_42().trap(arr));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Execution time: " + (duration / 1_000_000.0) + " milliseconds");


        long startTime2 = System.nanoTime();
        System.out.println(new TrappingRainWater_42().trap2(arr));
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        System.out.println("Execution time: " + duration2 + " nanoseconds");
        System.out.println("Execution time: " + (duration2 / 1_000_000.0) + " milliseconds");


    }
}
