package problem;

public class longestPalindrome00 {

    public static String longestPalindrome(String s) {
        String s1 = "";
        if(s.length() == 1){
            return s;
        }
        for(int i = 0 ;i < s.length()-1; i++){
            if(i == 0 && s.charAt(i) ==s.charAt(i+1)){
                s1 = s.substring(i,i+2);
            }
            else if(i == 0){
                s1 = s.substring(0,1);
            }
            else if(s.charAt(i) ==s.charAt(i+1)){
                if(i == s.length()-2){
                    String s2 = s.substring(i);
                    if (s2.length() > s1.length()) {
                        s1 = s2;
                    }
                }
                else {
                    String s2 = oddSolution(i - 1, i + 2, s);
                    if (s2.length() > s1.length()) {
                        s1 = s2;
                    }
                }
                String s2 = oddSolution(i-1,i+1,s);
                if(s2.length() > s1.length()) {
                    s1 = s2;
                }
            }
            else {
                String s2 = oddSolution(i-1,i+1,s);
                if(s2.length() > s1.length()) {
                    s1 = s2;
                }
            }
        }
        return s1;
    }
    //奇数
    public static String oddSolution(int low, int high, String s){
        while (low >= 0 && high < s.length()){
            if(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }
            else{
                break;
            }
        }
        String str = s.substring(low+1,high);
        return str;
    }
    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome00.longestPalindrome(s));
    }
}
