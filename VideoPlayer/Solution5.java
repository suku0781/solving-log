package VideoPlayer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Solution5 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime video_len_time = LocalTime.parse("00:"+video_len, formatter);
        LocalTime pos_time = LocalTime.parse("00:"+pos, formatter);
        LocalTime op_start_time = LocalTime.parse("00:"+op_start, formatter);
        LocalTime op_end_time = LocalTime.parse("00:"+op_end, formatter);

        for(int i = 0 ; i < commands.length; i++){
            if(!pos_time.isBefore(op_start_time) && !pos_time.isAfter(op_end_time)){ // +10초 하기 전 시간이 오프닝 시간 안에 있을 경우
                pos_time = op_end_time;
            }

            if(commands[i].equals("prev")) {
                if(pos_time.isAfter(LocalTime.MIDNIGHT.plusSeconds(10))) { // 00:00보다 큰지 확인
                    pos_time = pos_time.minusSeconds(10);
                } else {
                    pos_time = LocalTime.of(0, 0, 0);
                }
            } else {
                if(pos_time.isBefore(video_len_time.minusSeconds(10))) { //  비디오 마지막 보다 작은지 확인
                    pos_time = pos_time.plusSeconds(10);
                } else {
                    pos_time = video_len_time;
                }
            }
        }

        if(!pos_time.isBefore(op_start_time) && !pos_time.isAfter(op_end_time)){ // +10초 한 시간이 오프닝 시간 안에 있을 경우
            pos_time = op_end_time;
        }

        answer = pos_time.format(formatter).substring(3);

        return answer;
    }


    public static void main(String[] args) {
//        System.out.println(new Solution5().solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}) );
//        System.out.println( new Solution5().solution("10:55", "00:05", "00:15", "06:55", new String[] {"prev", "next", "next"} ) );
//        System.out.println(new Solution5().solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
        System.out.println(new Solution5().solution("07:22", "00:15", "00:15", "04:07", new String[]{"prev"}));
    }
}
