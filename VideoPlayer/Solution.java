package VideoPlayer;

class Time{
    String min;
    String sec;

    Time(String min, String sec){
        this.min = min;
        this.sec = sec;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setMin(int min){
        this.min = String.format("%02d", min);
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public void setSec(int sec) {
        this.sec = String.format("%02d", sec);
    }

    @Override
    public String toString() {
        return min + ":" + sec;
    }
}


class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        Time vidLenTime = new Time(video_len.split(":")[0], video_len.split(":")[1]);
        Time posTime = new Time(pos.split(":")[0], pos.split(":")[1]);

        for(int i = 0 ; i < commands.length; i++){
            int currLoc = 0; // 현재위치를 0 ~ 9 사이로 나타냄.

            switch (firstOrLast(vidLenTime, posTime)){
                case "first":
                    currLoc = 0;
                    break;
                case "last":
                    currLoc = 9;
                    break;
                default:
                    break;
            }

            if(commands[i].equals("prev") || currLoc > 0){
                calcTenMinutes(posTime, "sub");
            } else if(commands[i].equals("next") || currLoc < 9){
                calcTenMinutes(posTime, "add");
            } else {

            }

        }

        System.out.println("최종 결과 : " + posTime.toString());

        answer = posTime.toString();

        return answer;
    }

    String firstOrLast(Time vidLenTime,Time posTime){
        if(posTime.min.equals(vidLenTime.min) && posTime.sec.equals(vidLenTime.sec)){
            // 현재 위치가 마지막일 경우
            return "last";
        } else if(posTime.min.equals("00") && posTime.sec.equals("00")){
            // 현재 위치가 처음일 경우
            return "first";
        } else {
            // 처음도 아니고 마지막도 아닌 중간인 경우
            return "no";
        }
    }

    void calcTenMinutes(Time posTime, String sign){
        System.out.println("posTime.toString() : " + posTime.toString());
        if(sign.equals("add")){
            if(Integer.parseInt(String.valueOf(posTime.sec.charAt(0))) == 5){
                posTime.setMin( parseInt(posTime.min) + 1 );
                posTime.setSec( parseInt(posTime.sec) % 10 );
            } else {
                posTime.setSec( parseInt(posTime.sec) + 10 );
            }
        } else if(sign.equals("sub")){
            System.out.println("parseInt(posTime.sec) : " + posTime.toString());
            if(Integer.parseInt(String.valueOf(posTime.sec.charAt(0))) == 0){
                posTime.setMin( parseInt(posTime.min) - 1 );
                posTime.setSec( parseInt(posTime.sec) - 60 );

            } else {
                posTime.setSec( parseInt(posTime.sec) - 10 );
            }
        }
    }

    int parseInt(String str){
        return Integer.parseInt(String.valueOf(str));
    }


//    // 타입체크
//    class Check {
//        public static Class<Integer> typeof(final int expr) {
//            return Integer.TYPE;
//        }
//
//        public static Class<Long> typeof(final long expr) {
//            return Long.TYPE;
//        }
//
//        public static Class<Float> typeof(final float expr) {
//            return Float.TYPE;
//        }
//
//        public static Class<Double> typeof(final double expr) {
//            return Double.TYPE;
//        }
//
//        // ...
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        solution.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"});
//        solution.solution("34:33", "34:33", "00:55", "02:55", new String[]{"next", "prev"});
        solution.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"});
    }
}