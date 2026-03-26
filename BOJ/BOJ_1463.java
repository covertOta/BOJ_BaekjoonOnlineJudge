import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            int cnt = dp[i - 1] + 1;

            if (i % 3 == 0)
                cnt = Math.min(cnt, dp[i / 3] + 1);
            if (i % 2 == 0)
                cnt = Math.min(cnt, dp[i / 2] + 1);

            dp[i] = cnt;
        }
        System.out.println(dp[X]);


    }
}