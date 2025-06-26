public class SumOfKMirrorNumbersHard_2081 {

    public long kMirror(int k, int n) {
        long number = 1, sum = 0;
        while (n > 0){
            StringBuilder baseKNumber = convertBase10toBaseK(number, k);

            if(checkSymmetry(baseKNumber)){
                System.out.println(number + ",    " + baseKNumber);
                sum += number;
                n--;
            }
            number = nextBase10Number(number);
        }
        return sum;
    }

    public long nextBase10Number(long k) {
        StringBuilder number = new StringBuilder(String.valueOf(k));
        int center = number.length()/2;

        int indexLeft = number.length() % 2 == 0 ? center - 1: center, indexRight = center;
        while (true){
            if(indexLeft == 0 && number.charAt(indexLeft) == '9'){
                String next = "9".repeat(number.length());
                return Long.parseLong(next) + 2;
            }
            int nextCellValue = number.charAt(indexLeft) - '0' + 1;
            if(nextCellValue < 10){
                number.setCharAt(indexLeft, (char) (nextCellValue + '0'));
                number.setCharAt(indexRight, (char) (nextCellValue + '0'));
                return Long.parseLong(number.toString());
            }else{
                number.setCharAt(indexLeft--, '0');
                number.setCharAt(indexRight++, '0');
            }
        }
    }


    public int nextBaseNumber(int k, int base) {
        StringBuilder number = new StringBuilder(String.valueOf(k));
        int center = number.length()/2;

        int indexLeft = number.length() % 2 == 0 ? center - 1: center, indexRight = center;
        while (true){
            if(indexLeft == 0 && number.charAt(indexLeft) == (char) (base - 1 + '0')){
                return (int) Math.pow(10, number.length()) + 1;
            }
            int nextCellValue = number.charAt(indexLeft) - '0' + 1;
            if(nextCellValue < base){
                number.setCharAt(indexLeft, (char) (nextCellValue + '0'));
                number.setCharAt(indexRight, (char) (nextCellValue + '0'));
                return Integer.parseInt(number.toString());
            }else{
                indexLeft--;
                indexRight++;
            }
        }
    }

    public StringBuilder convertBase10toBaseK(long n, int k) {
        StringBuilder str = new StringBuilder();
        while (n > 0){
            str.append(n % k);
            n /= k;
        }
        return str.reverse();
    }

    public boolean checkSymmetry(StringBuilder n){
        StringBuilder str = new StringBuilder(n);
        StringBuilder reversed = new StringBuilder(str).reverse();
        return str.toString().equals(reversed.toString());
    }

    public static void main(String[] args) {
//        System.out.println(new SumOfKMirrorNumbersHard().convertBase10toBaseK(22, 2));
//        System.out.println(new SumOfKMirrorNumbersHard().kMirror(2, 5));
//        System.out.println(new SumOfKMirrorNumbersHard().kMirror(3, 7));
//        System.out.println(new SumOfKMirrorNumbersHard().kMirror(7, 17));

        System.out.println(new SumOfKMirrorNumbersHard_2081().nextBase10Number(2147557412l));
        System.out.println(new SumOfKMirrorNumbersHard_2081().kMirror(5, 25));
    }
}

