package BasicAlgorithm.SumOfTwoNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 데이터가 적다면 이중 for문 이것도 괜찮은 방법
    public static String solution(int[] numbers, int target) {
        for(int i = 0 ; i < numbers.length; i++){
            for(int j = i + 1 ; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    return Arrays.toString(new int[]{numbers[i], numbers[j]});
                }
            }
        }

        return "No Answer";
    }

    // 효율적으로 할려면
    public static String solution2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < numbers.length; i++){
            int complement = target - numbers[i];
            if(map.containsKey(complement)){
                return Arrays.toString(new int[]{complement, numbers[i]});
            }
            map.put(numbers[i], i);
        }
        return "No Answer";
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 7, 11, 15}, 9));
    }
}
