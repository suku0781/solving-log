package NumberOfServerExpansions;

public class PerfectAnswer {
    public int solution(int[] players, int m, int k) {
        int active = 0;            // 지금까지 살아 있는(가동 중인) 서버 수
        int answer = 0;            // 총 증설한 서버 수
        int[] window = new int[k]; // window[i % k]에 i시간에 추가된 서버 수를 기록

        for (int i = 0; i < players.length; i++) {
            int idx = i % k;

            // ──────────────────────────────────────────────
            // 1) i 시점에 유효기간(k시간) 지난 서버 만료 처리
            //    window[idx]는 (i - k) 시점에 설치된 서버 수
            active -= window[idx];
            window[idx] = 0;
            // ──────────────────────────────────────────────

            // 2) 이 시점에 ‘꽉 찬’ 서버 대수 계산 (floor division)
            int required = players[i] / m;

            // 3) 부족하면 즉시 증설
            if (required > active) {
                int add = required - active;
                window[idx] = add;   // i 시점에 add대 설치
                active += add;        // 가동 서버에 더하고
                answer += add;        // 총 증설 횟수에도 더한다
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PerfectAnswer solution = new PerfectAnswer();
        solution.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},3, 5);
//        solution.solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},3, 5);
//        solution.solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},3, 5);
    }
}
