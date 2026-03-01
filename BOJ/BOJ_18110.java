import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int minMaxRange = round(n);
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);
        int sum = 0;
        for (int i = minMaxRange; i < scores.length - minMaxRange; i++) {
            sum += scores[i];
        }

        int count = scores.length - (minMaxRange * 2);
        int avg = sum / count;

        if ((sum % count) * 2 >= count)
            avg++;

        System.out.println(avg);
    }

    static int round (int n) {
        int roudingNum = n * 15;

        if (roudingNum % 100 >= 50)
            roudingNum += 100;

        return roudingNum / 100;
    }
}
