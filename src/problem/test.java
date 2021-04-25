package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
    public static void Remove(String[] words){
        List<String> list = new ArrayList<>();
        for(int m = 0; m< words.length;m++){
            list.add(words[m]);
        }
        list.remove("word");
        System.out.println(list);
    }

    public static void main(String[] args) {
        String[] words = {"word","good","best","word"};
        Remove(words);
        String[] a = new String[10];
        System.out.println(a.length);
    }
}
