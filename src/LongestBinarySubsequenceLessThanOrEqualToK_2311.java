public class LongestBinarySubsequenceLessThanOrEqualToK_2311 {
    public int longestSubsequence(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for(int i=s.length() - 1; i >= 0; i--){
            System.out.println(sb.toString() + ", " + sb.length());
            sb.append(s.charAt(i));
            if(s.charAt(i) == '0') continue;
            if(!checkBinaryK(sb, k)){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.length();
    }

    private boolean checkBinaryK(StringBuilder sb, int k) {
        StringBuilder str = new StringBuilder(sb);
        str.reverse();
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') continue;
            res += (int) Math.pow(2, i);
            if(res > k) return false;
        }
        return res <= k;
    }


    public int longestSubsequence2(String s, int k) {
        int count = 0, power = 0, value = 0;
            for(int i = s.length() - 1; i >= 0; i--){
                char c = s.charAt(i);
                if(c == '0') count++;
                else{
                    if(value + (1<<power) <= k){
                        value += 1<<power;
                        count++;
                    }
                }
                power++;
            }
            return count;
        }



    public static void main(String[] args) {
        String s = "111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101";
        int k = 11713332;
//        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK_2311().longestSubsequence("1001010", 5));
//        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK_2311().longestSubsequence("00101001", 1));

//        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK_2311().longestSubsequence(s, k));


        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK_2311().longestSubsequence2("1001010", 5));
        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK_2311().longestSubsequence2("00101001", 1));
//        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK_2311().longestSubsequence2(s, k));
    }
}
