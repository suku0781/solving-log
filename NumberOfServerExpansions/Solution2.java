package NumberOfServerExpansions;

public class Solution2 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] window = new int[k];
        int activeServerNum = 0;

        for(int i = 0; i < players.length; i++){
            int idx = i % k; // 윈도우 슬라이딩

            // 유효기간 지난 서버 삭제
            activeServerNum -= window[idx];
            window[idx] = 0;

            // 필요한 서버갯수 계산
            int needServerCnt = players[i] / m;

            if(needServerCnt > activeServerNum){
                int addCnt = needServerCnt - activeServerNum;
                window[idx] = addCnt;
                activeServerNum += addCnt;
                answer += addCnt;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

//        System.out.println(solution.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},3, 5));
//        System.out.println(solution.solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},5, 1));
        System.out.println(solution.solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1));
    }
}
