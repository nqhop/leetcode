public class ConvertIntegerToSumOfTwoNoZero_1317 {
    public int[] getNoZeroIntegers(int n) {
        int i = 1, j = n - i;
        while(checkNoZero(i) || checkNoZero(j)){
            i++;
            j = n - i;
        }
        return new int[]{i, j};
    }

    public boolean checkNoZero(int n){
        String s = String.valueOf(n);
        return s.contains("0");
    }

    public static void main(String[] args) {
        int[] result = new ConvertIntegerToSumOfTwoNoZero_1317().getNoZeroIntegers(11);
        System.out.println(result[0] + " " + result[1]);
    }

}
