package BasicAlgorithm.RemoveDuplicates;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static String RemoveDuplicates(String s) {
        // 구현하세요
        Set<Character> alphabet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){
           if(!alphabet.contains(s.charAt(i))) {
               alphabet.add(s.charAt(i));
               sb.append(s.charAt(i));
           }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(RemoveDuplicates("programming")); // progamin
    }
}