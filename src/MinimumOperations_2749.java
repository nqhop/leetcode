public class MinimumOperations_2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        int i = 0, currentNumber;
        double closestToZero = num1, currentClosestToZero;
        while (true){
            currentNumber = 0;
            closestToZero = closestToZero - (Math.pow(2, currentNumber) + num2);
            currentClosestToZero = closestToZero;
            while (currentNumber < 60){
                currentNumber++;
                currentClosestToZero = Math.pow(2, currentNumber);
                if(Math.abs(closestToZero) < Math.abs(currentClosestToZero)){
                    currentNumber--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

/*
7 - (2^0 + 5) = 1
1 - (2^0 + 5) = -5
-5 - (2^0 + 5) = -11
-11
3 - (2^x + (-2)) =
 */