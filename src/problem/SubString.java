package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length()< words.length*words[0].length()){
            System.out.println("000");
            return list;
        }
        int length = words[0].length();
        for(int i = 0;i <= s.length()-words.length*words[0].length();i+=1){
            int right = i + length;
            int j = i;
            List<String> list1 = new ArrayList<>();
            for(int m = 0; m< words.length;m++){
                list1.add(words[m]);
            }
            System.out.println("first : " + list1);
            while(right - i <= words.length*words[0].length()){
                if(!list1.isEmpty()){
                    String str1 = s.substring(j,right);
                    if (list1.contains(str1)){
                        list1.remove(str1);
                        j+=length;
                        right+=length;
                        System.out.println("TWO : " + list1);
                        if(list1.isEmpty() && right - i > words.length*words[0].length()){
                            list.add(i);
                        }
                    }else{
                        break;
                    }
                }
                else{
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SubString fd = new SubString();
        List<Integer> list = new ArrayList<>();
        String str = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        list = fd.findSubstring(str,words);
        System.out.println(list);
    }
}
