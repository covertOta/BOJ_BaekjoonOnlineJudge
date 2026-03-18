import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 비밀번호 찾기
public class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        String input = "16 4\n" +
                "noj.am IU\n" +
                "acmicpc.net UAENA\n" +
                "startlink.io THEKINGOD\n" +
                "google.com ZEZE\n" +
                "nate.com VOICEMAIL\n" +
                "naver.com REDQUEEN\n" +
                "daum.net MODERNTIMES\n" +
                "utube.com BLACKOUT\n" +
                "zum.com LASTFANTASY\n" +
                "dreamwiz.com RAINDROP\n" +
                "hanyang.ac.kr SOMEDAY\n" +
                "dhlottery.co.kr BOO\n" +
                "duksoo.hs.kr HAVANA\n" +
                "hanyang-u.ms.kr OBLIVIATE\n" +
                "yd.es.kr LOVEATTACK\n" +
                "mcc.hanyang.ac.kr ADREAMER\n" +
                "startlink.io\n" +
                "acmicpc.net\n" +
                "noj.am\n" +
                "mcc.hanyang.ac.kr";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String url = br.readLine();
            sb.append(map.get(url)).append("\n");
        }
        System.out.println(sb);
    }
}
