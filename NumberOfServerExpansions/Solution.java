package NumberOfServerExpansions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[] players, int m, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int offerServerCnt = 0; // 서버 증설 횟수

        for(int i = 0; i < players.length; i++){
            int needServerNum = 0;

            // 시간 초과 서버 제거
            while(!queue.isEmpty()){
                int serverTime = queue.peek();
                if(serverTime == i ){
                    queue.poll();
                } else {
                    break;
                }
            }

            // 필요 서버 갯수 계산
//            if( players[i] / m > 0 && players[i] % m != 0 ){
//                needServerNum = (players[i] / m + 1);
//            } else {
//                needServerNum = players[i] / m;
//            }`
            needServerNum = players[i] / m;
            needServerNum -= queue.size();

            while(needServerNum-- > 0){
                queue.offer(i + k);
                offerServerCnt++;
            }
        }

        System.out.println("offerServerCnt : " + offerServerCnt);

        answer = offerServerCnt;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        new Solution().solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5);
//        new Solution().solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, 5, 1);
        new Solution().solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1);

    }
}