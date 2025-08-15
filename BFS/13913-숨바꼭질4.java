import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx={-1,1};
    static int n;
    static int k;
    static int[] log = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        n = Integer.parseInt(rc[0]);
        k = Integer.parseInt(rc[1]);
        bfs(n);
    }

    private static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] time = new int [100001]; // 각 위치에 도달하는데 필요한 최소 시간 저장 배열
        for (int i = 0; i < 100001; i++) {
            time[i] = -1;
        }
        time[start] = 0;
        q.addLast(start);

        while(!q.isEmpty()) {
            int cur = q.removeFirst();
            if(cur == k) {
                printRoute(cur, time[cur]);
            }

            // 순간이동
            int pos = 2*cur;
            if(isInside(pos) && time[pos] == -1) {
                time[pos] = time[cur]+1;
                q.addLast(pos);
                log[pos] = cur;
            }
            for (int i = 0; i < 2; i++) {
                int walk = cur+dx[i];
                if(isInside(walk) && time[walk] == -1) {
                    time[walk] = time[cur] + 1;
                    q.addLast(walk);
                    log[walk] = cur;
                }
            }
        }
    }

    private static boolean isInside(int pos) {
        return pos>=0 && pos<=100000;
    }

    private static void printRoute(int idx, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(len).append('\n');
        Deque<Integer> history = new ArrayDeque<>(len);
        int position = idx;
        for (int i = 0; i < len+1; i++) {
            history.addLast(position);
            position = log[position];
        }
        while(!history.isEmpty()) {
            sb.append(history.removeLast()).append(' ');
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
