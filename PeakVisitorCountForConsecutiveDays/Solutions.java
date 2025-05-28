package PeakVisitorCountForConsecutiveDays;

public class Solutions {
    public int maxVisitorSum(int[] visits, int k) {
        int maxSum = 0;
        int bfSum = 0;

        for(int i = 0 ; i < k ; i++){
            bfSum += visits[i];
        }
        maxSum = bfSum;

        for (int i = k ; i < visits.length ; i++){
            // bfsum에 visits 저장
            bfSum += visits[i];
            bfSum -= visits[i - k];

//            int sum = Arrays.stream(window).sum(); // 시간복잡도가 늘어남.

            if(maxSum < bfSum) maxSum = bfSum;

            System.out.println("maxSum : " + maxSum + ", bfSum : " + bfSum + ", i : " + i + ", k : " + k);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solutions solution = new Solutions();
        System.out.println(solution.maxVisitorSum(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5}, 3));
    }
}

