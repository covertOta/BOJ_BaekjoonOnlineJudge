import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        String input = "5\n" +
                "3 1 4 3 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        /*int sum = 0;
        int preSum = 0;
        for (int time : times) {
            sum += time + preSum;
            preSum += time;
        }*/

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += times[i] * (N - i);
        }
        System.out.println(sum);
    }
}
