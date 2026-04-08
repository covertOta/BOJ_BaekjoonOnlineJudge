import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {
        String input = "7\n" +
                "6\n" +
                "1 2\n" +
                "2 3\n" +
                "1 5\n" +
                "5 2\n" +
                "5 6\n" +
                "4 7";
        //4
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pcCount = Integer.parseInt(br.readLine());
        int linkCount = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[pcCount + 1];

        for (int i = 1; i < pcCount + 1; i++) {
            nodes[i] = new Node();
        }

        StringTokenizer st;
        for (int i = 0; i < linkCount; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            nodes[com1].nodes.add(com2);
            nodes[com2].nodes.add(com1);
        }

        boolean[] checked = new boolean[pcCount + 1];
        int infected = 0;
        Deque<Node> deque = new ArrayDeque<>();
        checked[1] = true;
        deque.add(nodes[1]);

        while (!deque.isEmpty()) {
            Node node = deque.pop();
            for (int com : node.nodes) {
                if (!checked[com]) {
                    checked[com] = true;
                    infected++;
                    deque.add(nodes[com]);
                }
            }
        }

        System.out.println(infected);
    }
}

class Node {
    Set<Integer> nodes = new HashSet<>();
}