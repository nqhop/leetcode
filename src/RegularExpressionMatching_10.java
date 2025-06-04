public class RegularExpressionMatching_10 {
    public boolean isMatch (String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        boolean match = true;
        if(s.length() == 0 || (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.')) {
            match = false;
        }
        if(p.length() == 1 || p.charAt(1) != '*') {
            return match && isMatch(s.substring(1), p.substring(1));
        } else {
            if(isMatch(s, p.substring(2))) {
                return true;
            } else {
                return (match && isMatch(s.substring(1), p));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching_10().isMatch("aa", "a"));
    }
}
