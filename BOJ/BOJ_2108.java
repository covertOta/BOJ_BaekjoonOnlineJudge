import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        String input = "3\n" +
                "0\n" +
                "0\n" +
                "-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] counts = new int[8002];

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[i] = n;
            counts[n + 4000]++;
            sum += n;

            if (counts[n + 4000] > maxCount)
                maxCount = counts[n + 4000];
        }

        Arrays.sort(nums);

        boolean flag = false;
        int mode = 0;
        for (int i = 0; i < counts.length; i++) {
            int n = counts[i];
            if (n == maxCount) {
                mode = i - 4000;
                if (flag) break;

                flag = true;
            }
        }

        sb.append(rounding(sum, N)).append("\n");
        sb.append(nums[N / 2]).append("\n");
        sb.append(mode).append("\n");
        sb.append(nums[N - 1] - nums[0]).append("\n");

        System.out.println(sb);
    }

    static int rounding(int sum, int n) {
        int divide = sum / n; //7
        boolean isMinus = divide < 0;

        if (Math.abs(sum % n) * 2 >= n) {
            if (isMinus) divide--;
            else divide++;
        }

        return divide;
    }
}

/*
0
0
0
1
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값. 여러개 일 경우 작은 값 중 두번째
범위 : N개의 수들 중 최댓값과 최솟값의 차이
*/