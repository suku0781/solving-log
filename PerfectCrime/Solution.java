package PerfectCrime;

import java.util.Arrays;

public class Solution {
  public int solution(int[][] info, int n, int m) {
    int answer = 0;
    int a = 0;
    int b = 0;
    int[] thiefA = new int[info.length];
    int[] thiefB = new int[info.length];

    int[][] sortedInfo = new int[info.length][2];

    // info 분리
    for(int i = 0; i < info.length; i++){
      thiefA[i] = info[i][0];
      thiefB[i] = info[i][1];
    }

    int thiefAMax = Arrays.stream(thiefA).max().getAsInt();
    int thiefBMax = Arrays.stream(thiefB).max().getAsInt();

    // 정렬
//    if(Arrays.stream(thiefA).sum() > Arrays.stream(thiefB).sum()) {
//      thiefThingSort(thiefA, thiefB);
//    } else {
//      thiefThingSort(thiefB, thiefA);
//    }


    int checkCnt = info.length - 1 ; // 검증 횟수


    // 검증
    for(int i = 0; i < info.length; i++){
      if(i > checkCnt){
        if(thiefA[i] + thiefA[i + 1] > thiefB[i] + thiefB[i + 1]){
          if(n > thiefA[i] + thiefA[i + 1]){
            a += thiefA[i];
          }

        } else {
          if(m > thiefB[i] + thiefB[i + 1]){
            b += thiefB[i];
          }

        }
        System.out.println("i : " + i + ", thiefA[i] : " + thiefA[i] + ", thiefB[i] : " + thiefB[i]);
      }

      System.out.println("a : " + a + ", b : " + b);
    }



    return answer;
  }

  // 정렬
//  int[][] thiefThingSort(int[] thief, int[] targetThief) {
//    Arrays.stream(thief).sorted();
//
//    for(int i = 0; i < targetThief.length; i++){
//      int tmp = 0;
//
//      for(int j = 0; j < thief.length; j++){
//        if(targetThief[i] == thief[j]) {
//          tmp = thief[j];
//          break;
//        }
//      }
//
//      targetThief[i] = tmp;
//
//
//        sortedInfo[i][0] = 1;
//        sortedInfo[i][1] = thiefA[i];
//    }
//
//  }


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