public class FindNUniqueIntegerSumUpToZero_1304 {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        for(int i = 0, j = (n % 2 == 0 ? n - 1 : n - 2); i < (int) (n / 2); i++, j--){
            arr[i] = i + 1;
            arr[j] = -(i + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] result = new FindNUniqueIntegerSumUpToZero_1304().sumZero(3);
    }
}
