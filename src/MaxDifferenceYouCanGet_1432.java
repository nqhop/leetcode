import java.util.Arrays;

public class MaxDifferenceYouCanGet_1432 {
    public int maxDiff(int num) {
        String[] numbers = String.valueOf(num).split("");
        String x, y = "9";
        int i = 0, a, b;
        while (i < numbers.length - 1 && numbers[i].equals("9")){
            i++;
        }
        x = numbers[i];
        a = Integer.valueOf(String.join("", numbers).replaceAll(x, y));

        // find min
        x = numbers[0];
        y = "1";
        if(numbers[0].equals("1")){
            i = 1;
            while (i < numbers.length && (numbers[i].equals("1") || numbers[i].equals("0"))){
                i++;
            }
            if(i < numbers.length) {
                x = numbers[i];
                y = "0";
            }
        }


        b = Integer.valueOf(String.join("", numbers).replaceAll(x, y));

        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        System.out.println(new MaxDifferenceYouCanGet_1432().maxDiff(123456));
    }
}
