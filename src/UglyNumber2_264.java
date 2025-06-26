public class UglyNumber2_264 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0, next2, next3, next5, nextUgly;
        for(int i = 1; i < n; i++) {
            next2 = ugly[i2] * 2;
            next3 = ugly[i3] * 3;
            next5 = ugly[i5] * 5;

            nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;

            if (nextUgly == next2) i2++;
            if (nextUgly == next3) i3++;
            if (nextUgly == next5) i5++;
        }

        return ugly[n - 1];
    }



    public static void main(String[] args) {
        System.out.println(new UglyNumber2_264().nthUglyNumber(10));
    }
}
