package BasicAlgorithm.ValidPalindrome;

public class Palindrome {
    public static boolean isPalindrome(String s) { // 문장 전체를 비교
        // 구현하세요
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeWord(String s) { // 단어별로 비교
        String[] words = s.toLowerCase().split(" ");

        for(String word : words){
            int left = 0, right = word.length() - 1;
            while (left < right) {
                if (word.charAt(left) != word.charAt(right)) return false;
                left++;
                right--;
            }
        }

        return true; // 모든 단어가 팰린드롬이어야 true 리턴
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome("A man a plan a canal Panama")); // true
        System.out.println(isPalindrome("apple")); // false
        System.out.println(isPalindromeWord("A man a plan a canal Panama")); // false
        System.out.println(isPalindromeWord("apple")); // false
    }
}
