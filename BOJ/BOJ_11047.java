import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        String input = "10 4200\n" +
                "1\n" +
                "5\n" +
                "10\n" +
                "50\n" +
                "100\n" +
                "500\n" +
                "1000\n" +
                "5000\n" +
                "10000\n" +
                "50000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int cursor = N - 1;
        while (K > 0) {
            int coin = coins[cursor--];
//            if (coin > K) continue;

            count += K / coin;
            K %= coin;
        }
        System.out.println(count);

    }
}
