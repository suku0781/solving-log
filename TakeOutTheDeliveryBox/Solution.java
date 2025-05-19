package TakeOutTheDeliveryBox;

import java.util.*;

public class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        /*
        제약조건 이행
        2 ≤ n ≤ 100
        1 ≤ w ≤ 10
        1 ≤ num ≤ n
        */
        if(n < 1 || w < 0 || w > 11 || num < 0 || num > n ) return 0;
        if(n < w) { // n 이 w 보다 작을 경우 한 행밖에 없으므로 1을 리턴하면 됨.
            System.out.println("최종 n < w ; " + (n < w));
            return 1;
        }

        int row = n / w;
        if(row != 0) row = row + 1;
        int targetCol = 0;

        int[][] array = new int[row][w];

        for(int i = 0 ; i < n ; i++) {
            int tmpRow = i / w;
            int tmpCol = 0;

            if(tmpRow % 2 == 0){
                tmpCol = i % w;
                array[tmpRow][tmpCol] = i+1;
            } else {
                tmpCol = (w * (tmpRow + 1)) - (i + 1);
                array[tmpRow][tmpCol] = i + 1;
            }

            System.out.println(Arrays.deepToString(array));

            if(i + 1 == num) {
                targetCol = tmpCol;
            }
        }

        for(int i = row - 1 ; i >= 0 ; i--){
            if(array[i][targetCol] != 0){
                answer++;
            }

            if(array[i][targetCol] == num) {
                System.out.println("i " + i);
                break;
            }
        }

        System.out.println("최종 answer ; " + answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3,9,2);
    }
}