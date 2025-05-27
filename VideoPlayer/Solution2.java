package VideoPlayer;

import java.util.function.Function;

class Time2{
    String vidLenMin = "";
    String vidLenSec = "";
    String posMin = "";
    String posSec = "";
    int opStart = 0;
    int opEnd = 0;

    Time2(){

    }

    Time2(String video_len, String pos, String opStart, String opEnd){
        this.vidLenMin = video_len.split(":")[0];
        this.vidLenSec = video_len.split(":")[1];
        this.posMin = pos.split(":")[0];
        this.posSec = pos.split(":")[1];
        this.opStart = Integer.parseInt(opStart.replace(":", ""));
        this.opEnd = Integer.parseInt(opEnd.replace(":", ""));
    }

    public void setTime (int posMin, int posSec){
        this.posMin = String.format("%02d", posMin);
        this.posSec = String.format("%02d", posSec);
    }

    public void setTime (String posMin, String posSec){
        this.posMin = posMin;
        this.posSec = posSec;
    }

    @Override
    public String toString() {
        return posMin + ':' + posSec;
    }
}

class Solution2 {
    static Time2 time = new Time2();

    public String solution2(String[] commands) {
        String answer = "";

        for(int i = 0; i < commands.length; i++){
            calcLoc(commands[i]);
        }

        System.out.println(time.toString());



        return answer;
    }

    // 앞으로 또는 뒤로 이동
    // 00:50 -> 01:00 , 05:00 -> 04:50 이런식으로 될 경우 분 +1 함수
    void calcLoc(String command){
        Function<String, Integer> p2I = Integer::parseInt;
        int tmpMin = 0;
        int tmpSec = 0;

        System.out.println("여기도 오는지 테스트 : " + command);

        if(command.equals("next")){
            if(!time.posMin.equals(time.vidLenMin) && !time.posSec.equals(time.vidLenSec)){
                if(p2I.apply(time.posSec) > 50){
                    int tTmpMin = p2I.apply(time.posMin) + 1;
                    int tTmpSec = p2I.apply(time.posSec) % 10;
                    int tTMS = tTmpMin + tTmpSec;

                    if(time.opStart <= tTMS && time.opEnd >= tTMS ){
//                        time.opEnd+tTms;

                        tmpMin = p2I.apply(time.posMin) + 1;
                        tmpSec = p2I.apply(time.posSec) % 10;
                    } else {
                        tmpMin = tTmpMin;
                        tmpSec = tTmpSec;
                    }

                } else {
                    tmpMin = p2I.apply(time.posMin);
                    tmpSec = p2I.apply(time.posSec) + 10;
                }
            }
        } else {
            if(!time.posMin.equals("00") && !time.posSec.equals("00")){
                if(p2I.apply(time.posSec) < 10){
                    tmpMin = p2I.apply(time.posMin) - 1;
                    tmpSec = ((p2I.apply(time.posSec) * 10) % 10) + 50;
                } else {
                    tmpMin = p2I.apply(time.posMin);
                    tmpSec = p2I.apply(time.posSec) - 10;
                }
            }
        }

        time.setTime(tmpMin, tmpSec);
    }



    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        String video_len = "10:55";
//        String pos = "00:05";
//        String op_start = "00:15";
//        String 	op_end = "06:55";
//        String[] commands = {"prev", "next", "next"};
//
        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String 	op_end = "04:07";
        String[] commands = {"next"};

        time = new Time2(video_len, pos, op_start, op_end);
        solution2.solution2(commands);
    }
}