package BasicAlgorithm.SnailMatrix;

import java.util.Arrays;

public class Solution {
    /*
    * N x N 2차원 배열에 1부터 N*N까지 달팽이(나선형)으로 숫자를 채우는 함수를 작성하세요.
    * 1 2 3
    * 8 9 4
    * 7 6 5
    * */
    public String solution(int n) {
        // 구현하세요
        int[][] matrix = new int[n][n];
        int[] dx = {0, 1, 0, -1}; // 시계 방향으로 이동
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int x = 0; // x 좌표
        int y = 0; // y 좌표

        for(int i = 1; i <= n*n; i++){
            matrix[x][y] = i; // 순서대로 matrix에 저장

            // 다음 방향 전환 변수 생성
            int tx = x + dx[dir];
            int ty = y + dy[dir];

            // 다음 뱡향이 벽이거나 이미 채워진 곳일 경우 방향 전환
            if (tx < 0 || ty < 0 || tx >= n || ty >= n || matrix[tx][ty] != 0){
                dir = (dir + 1) % 4; // 다음 방향 지정
                tx = x + dx[dir];
                ty = y + dy[dir];
            }

            x = tx;
            y = ty;
        }

        return Arrays.deepToString(matrix);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(9));

    }
}
