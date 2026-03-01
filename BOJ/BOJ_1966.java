

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        String input =
                "3\n" +
                        "1 0\n" +
                        "5\n" +
                        "4 2\n" +
                        "1 2 3 4\n" +
                        "6 0\n" +
                        "1 1 9 1 1 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int total = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Deque<int[]> deque = new ArrayDeque<>();
            int[] ranks = new int[total];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < total; j++) {
                int rank = Integer.parseInt(st.nextToken());
                deque.add(new int[]{j, rank});
                ranks[j] = rank;
            }

            Arrays.sort(ranks);
            int maxIdx = total - 1;
            int pos = 0;

            while (!deque.isEmpty()) {
                int[] idxRank = deque.poll();
                if (idxRank[1] == ranks[maxIdx]) {
                    maxIdx--;
                    pos++;
                    if (idxRank[0] == target) {
                        sb.append(pos).append("\n");
                        break;
                    }
                } else {
                    deque.offer(idxRank);
                }
            }

        }
        System.out.println(sb);
    }
}
