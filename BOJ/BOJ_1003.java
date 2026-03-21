import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        String input = "3\n" +
                "0\n" +
                "1\n" +
                "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];

        zeroCount[0] = 1;
        oneCount[1] = 1;

        for (int i = 2; i < 41; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zeroCount[N])
                    .append(" ")
                    .append(oneCount[N])
                    .append("\n");
        }


        System.out.println(sb);
    }

}
