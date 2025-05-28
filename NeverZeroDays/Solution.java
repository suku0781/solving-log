package NeverZeroDays;

public class Solution {
    public int countZeroRainWindows(int[] rain, int k) {
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += rain[i];
        }

        if(sum == 0) answer++;

        for(int i = k; i < rain.length; i++){
            sum += rain[i];
            sum -= rain[i - k];

            if(sum == 0) answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countZeroRainWindows(new int[]{0, 2, 0, 0, 3, 0, 0, 1, 0, 0, 0}, 3));
    }
}
