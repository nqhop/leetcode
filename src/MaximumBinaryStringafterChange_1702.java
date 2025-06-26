public class MaximumBinaryStringafterChange_1702 {
    public String maximumBinaryString(String binary) {
        binary = binary.replaceAll("00", "10");
        while(true){
            String str = binary.replaceAll("00", "10");
            if(str.equals(binary)) break;
            binary = str;
        }
        int count0InBinary = 0;
        for(int i = binary.length()-1; i >= 0; i--){
            if(binary.charAt(i) == '0') count0InBinary++;
        }
        if(count0InBinary < 2) return binary;
        int firstIndexOfZero = binary.indexOf('0');
        String res =  "1".repeat(firstIndexOfZero + count0InBinary - 1) + "0" + "1".repeat(binary.length() - (firstIndexOfZero + count0InBinary));
        return res;
    }




    public static void main(String[] args) {
//        System.out.println(new MaximumBinaryStringafterChange_1702().maximumBinaryString("000110"));
//        System.out.println(new MaximumBinaryStringafterChange_1702().maximumBinaryString("11"));
        System.out.println(new MaximumBinaryStringafterChange_1702().maximumBinaryString("01111001100000110010"));
    }

}

/*
01111001100000110010
 */