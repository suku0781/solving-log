package VideoPlayer;

class Time3{
    int vidLen = 0;
    int pos = 0;
    int opStart = 0;
    int opEnd = 0;

    Time3(String video_len, String pos, String opStart, String opEnd){
        this.vidLen = Integer.parseInt(video_len.replace(":", ""));
        this.pos = Integer.parseInt(pos.replace(":", ""));
        this.opStart = Integer.parseInt(opStart.replace(":", ""));
        this.opEnd = Integer.parseInt(opEnd.replace(":", ""));
    }

    @Override
    public String toString() {
        String min = String.format("%02d", pos / 100);
        String sec = String.format("%02d", pos % 100);

        return min + ":" + sec;
    }
}

class Solution3 {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        Time3 time = new Time3(video_len, pos, op_start, op_end);

        for(int i = 0; i < commands.length; i++){
            int tmpTime = 0;

            if(commands[i].equals("next")) {
                if(time.opStart <= time.pos && time.opEnd >= time.pos) {
                    time.pos = time.opEnd;
                }
            } else {
                if(time.opStart <= time.pos && time.opEnd >= time.pos) {
                    time.pos = time.opStart;
                }
            }

            if(commands[i].equals("next")){
                if(time.pos != time.vidLen && ((time.pos / 100 < time.vidLen / 100) || (time.pos % 100 < time.vidLen % 100))){ // 넘기기 하려는데 마지막이 아닐경우에만 넘기기 가능
                    if((time.pos % 100) > 50 ){ // 현재위치가 50초 이상일 경우
                        tmpTime = (time.pos / 100 + 1) * 100;
                        tmpTime += time.pos % 10;

                        // 10초 앞으로 갔는데 위치가 만약 오프닝 구간일 경우 오프닝이 끝나는 지점으로 이동
                        if(time.opStart <= tmpTime || time.opEnd >= tmpTime) tmpTime = time.opEnd;
                    } else {
                        tmpTime = time.pos + 10;
                    }
                    time.pos = tmpTime;
                } else {
                    time.pos = time.vidLen;
                }
            } else {
                if(time.pos != 0 && ((time.pos / 100 > 0) || (time.pos % 100 > 0)) ){ // 뒤로 하려는데 처음이 아닐경우에만 앞으로 가능
                    if((time.pos % 100) > 10 ){ // 현재위치가 10초 이상일 경우
                        tmpTime = (time.pos / 100 - 1) * 100;
                        tmpTime += (time.pos % 10) + 50;

                        // 10초 뒤로 갔는데 위치가 만약 오프닝 구간일 경우 오프닝이 끝나는 지점으로 이동
//                    if(time.opStart <= tmpTime || time.opEnd >= tmpTime) tmpTime = time.opEnd;
                    } else {
                        tmpTime = time.pos - 10;
                    }

                    time.pos = tmpTime;
                } else {
                    time.pos = 0;
                }
            }

            if(commands[i].equals("next")) {
                if(time.opStart <= time.pos && time.opEnd >= time.pos) {
                    time.pos = time.opEnd;
                }
            } else {
                if(time.opStart <= time.pos && time.opEnd >= time.pos) {
                    time.pos = time.opStart;
                }
            }
        }

        answer = time.toString();

        return answer;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        solution.solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"});
    }
}