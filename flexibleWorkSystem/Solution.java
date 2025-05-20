package flexibleWorkSystem;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int perception = 0;
        int saturday = 0;
        int sunday = 0;

        // 제약사항
        if(schedules.length != timelogs.length || startday < 1 || startday > 7) return 0;

        if(startday == 7){
            saturday = 6;
            sunday = 0;
        } else {
            saturday = 7 - startday - 1;
            sunday = 7 - startday;
        }

        System.out.println("saturday " + saturday + ", sunday " + sunday);

        for(int i = 0; i < schedules.length; i++){
            int commuteTime = schedules[i];

            System.out.println("commuteTime: " + commuteTime);
            if(schedules[i] >= 700 && schedules[i] <= 1100){
                for(int j = 0; j < timelogs[i].length; j++){
                    if(j != saturday && j != sunday && (commuteTimePlus10(commuteTime)) < timelogs[i][j]){
                        perception++;
                        break;
                    }
                }
            }

            System.out.println("perception : " + perception);
        }

        answer = schedules.length - perception;

        System.out.println(answer);

        return answer;
    }

    static int commuteTimePlus10(int time){
        if(time % 100 >= 50){
            return Integer.parseInt((time / 100 + 1) + "0" + time % 10);
        } else {
            return time + 10;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] schedules = {700, 800, 1100};
//        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};

        int[] schedules = {755, 855, 700, 720};
        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};

        solution.solution(schedules, timelogs, 1);
    }
}