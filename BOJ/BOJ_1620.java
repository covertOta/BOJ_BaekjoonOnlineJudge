import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        String input =
                "26 5\n" +
                        "Bulbasaur\n" +
                        "Ivysaur\n" +
                        "Venusaur\n" +
                        "Charmander\n" +
                        "Charmeleon\n" +
                        "Charizard\n" +
                        "Squirtle\n" +
                        "Wartortle\n" +
                        "Blastoise\n" +
                        "Caterpie\n" +
                        "Metapod\n" +
                        "Butterfree\n" +
                        "Weedle\n" +
                        "Kakuna\n" +
                        "Beedrill\n" +
                        "Pidgey\n" +
                        "Pidgeotto\n" +
                        "Pidgeot\n" +
                        "Rattata\n" +
                        "Raticate\n" +
                        "Spearow\n" +
                        "Fearow\n" +
                        "Ekans\n" +
                        "Arbok\n" +
                        "Pikachu\n" +
                        "Raichu\n" +
                        "25\n" +
                        "Raichu\n" +
                        "3\n" +
                        "Pidgey\n" +
                        "Kakuna";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제 수

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(str, i);
            arr[i] = str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (target.charAt(0) < 58)
                sb.append(arr[Integer.parseInt(target)]);
            else
                sb.append(map.get(target));

            sb.append("\n");
        }
        System.out.println(sb);

    }
}
/*
Pikachu
26
Venusaur
16
14
* */