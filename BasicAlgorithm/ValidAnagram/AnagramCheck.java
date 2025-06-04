package BasicAlgorithm.ValidAnagram;

import java.util.*;

public class AnagramCheck {
    public static boolean isAnagram(String s1, String s2) {
        // 구현하세요
        // 객체 생성<알파벳, 갯수>
        HashMap<Character, Integer> s1Alphabets = new HashMap<>(s1.length());
        HashMap<Character, Integer> s2Alphabets = new HashMap<>(s2.length());

        // 소문자 변환, 공백 제거
        s1 = s1.toLowerCase().replaceAll("\\s", "");
        s2 = s2.toLowerCase().replaceAll("\\s", "");

        for(char c : s1.toCharArray()){
            s1Alphabets.put(c, s1Alphabets.getOrDefault(c, 0) + 1 );
        }

        for(char c : s2.toCharArray()){
            s2Alphabets.put(c, s2Alphabets.getOrDefault(c, 0) + 1 );
        }

        return s1Alphabets.equals(s2Alphabets);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("Listen", "Silent")); // true
        System.out.println(isAnagram("apple", "papel")); // true
        System.out.println(isAnagram("apple", "banana")); // false
    }
}
