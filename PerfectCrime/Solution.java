package PerfectCrime;

import java.util.Arrays;

public class Solution {
  public int solution(int[][] info, int n, int m) {
    int answer = 0;
    int a = 0;
    int b = 0;
    int[] thiefA = new Integer()[info.length];
    int[] thiefB = new Int()[info.length];

    for(int i = 0 ; i < info.length; i++ ){
      thiefA[i] = info[i][0];
      thiefB[i] = info[i][1];
    }

    System.out.println("thiefA : " + thiefA);
    System.out.println("thiefB : " + thiefB);

    

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4));
    // System.out.println(new Solution().solution(new int[][]{{3, 3}, {3, 3}}, 7, 1));
    // System.out.println(new Solution().solution(new int[][]{{3, 3}, {3, 3}}, 6, 1));
  }
}

/**
 * info 2차원 배열에서 첫번재는 a도둑 흔적, 두번째는 b도둑의 흔적임
 * a도둑 흔적 갯수의 최솟값을 리턴해야함. 


 */