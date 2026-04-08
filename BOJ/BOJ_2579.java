import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        String input = "6\n" +
                "10\n" +//
                "20\n" +//
                "15\n" +
                "25\n" +//
                "10\n" +
                "20"; //  75
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(scores[0]);
            return;
        } else if (N == 2) {
            System.out.println(scores[0] + scores[1]);
            return;
        }

        int[] dp = new int[N];
        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }

        System.out.println(dp[N - 1]);
    }
}