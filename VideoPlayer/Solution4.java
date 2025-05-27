//package VideoPlayer;
//
//class Solution4 {
//    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
//        String answer = "";
//
//        int vidLen = Integer.parseInt(video_len.replace(":", ""));
//        int now = Integer.parseInt(pos.replace(":", ""));
//        int opStart = Integer.parseInt(op_start.replace(":", ""));
//        int opEnd = Integer.parseInt(op_end.replace(":", ""));
//
//        for(int i = 0 ; i < commands.length; i++){
//            now = calcPos(vidLen, now, opStart, opEnd, commands[i]);
//        }
//
//        answer = timeToStr(now);
//        System.out.println(answer);
//        return answer;
//    }
//
//    int calcPos(int vidLen, int now, int opStart, int opEnd, String command){
//        int rt= 0;
//
//        int digit10 = 1;
//        int digit = 0;
//        for(int i = 0 ; i < calcLen(now) ; i++){
//            digit10 *= 10;
//            digit++;
//        }
//
//        if(command.equals("prev")){
//            if(digit > 0 && (now / digit10) > 1 ){ // 00:00보다 크고 00:10보다 클 경우
//                rt = timeAdjustment(now - 10);
//                if(rt >= opStart && rt <= opEnd){
//                    rt = opEnd;
//                }
//            }
//        } else {
//            if(vidLen > now && vidLen + 10 > now){ // 마지막 보다 작고 마지막-10 보다 작을 경우
//                rt = timeAdjustment(now + 10);
//                if(rt >= opStart && rt <= opEnd){
//                    rt = opEnd;
//                }
//            } else {
//                rt = vidLen;
//            }
//        }
//
//        return rt;
//    }
//
//    int calcLen(int num) {
//        int cnt = 0;
//        while(num > 0){
//             num /= 10;
//             cnt++;
//        }
//        return cnt;
//    int timeAdjustment(int rt) {
//        return Integer.parseInt(String.format("%02d%02d", (rt / 100) / 60, (rt % 100) % 60));
//    }
//
//    String timeToStr(int rt) {
//        return String.format("%02d%02d", rt / 60, rt % 60);
//    }
//
//    public static void main(String[] args) {
//        Solution4 solution4 = new Solution4();
//
//        solution4.solution("34:33",	"13:00",	"00:55",	"02:55", new String[]{"next", "prev"});
//    }
//}