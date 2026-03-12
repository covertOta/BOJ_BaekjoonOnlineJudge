import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_2 {
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

        HashSet<String> duts = new HashSet<>();
        for (int i = 0; i < N; i++) {
            duts.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String bo = br.readLine();
            if (duts.contains(bo)) {
                list.add(bo);
            }
        }

        Collections.sort(list);
        for (String bo : list) {
            sb.append(bo).append("\n");
        }
        System.out.println(list.size());
        System.out.println(sb);
    }

}
