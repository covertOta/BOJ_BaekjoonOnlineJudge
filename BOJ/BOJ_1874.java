import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        String input =
                "8\n" +
                        "4\n" +
                        "3\n" +
                        "6\n" +
                        "8\n" +
                        "7\n" +
                        "5\n" +
                        "2\n" +
                        "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int start = 1;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (start <= target) {
                stack.push(start);
                sb.append("+").append("\n");
                start++;
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
