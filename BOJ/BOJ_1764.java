import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        String input = "3 4\n" +
                "ohhenrie\n" +
                "charlie\n" +
                "baesangwook\n" +

                "obama\n" +
                "baesangwook\n" +
                "ohhenrie\n" +
                "clinton";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] duts = new String[N];
        String[] bos = new String[M];
        for (int i = 0; i < N; i++) {
            duts[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            bos[i] = br.readLine();
        }

        Arrays.sort(duts);
        Arrays.sort(bos);

        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < N && p2 < M) {
            String dut = duts[p1];
            String bo = bos[p2];
            int compare = dut.compareTo(bo);

            if (compare == 0) {
                p1++;
                p2++;
                count++;
                sb.append(dut).append("\n");
            } else if (compare > 0) {
                p2++;
            } else {
                p1++;
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
