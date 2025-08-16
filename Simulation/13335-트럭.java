import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input1 = Arrays.stream(br.readLine().split(" "))
							 .mapToInt(Integer::parseInt)
							 .toArray();

        int N = input1[0];
        int W = input1[1];
        int L = input1[2];

        int[] trucks = new int[N+1];
        int[] input2 = Arrays.stream(br.readLine().split(" "))
							 .mapToInt(Integer::parseInt)
							 .toArray();
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(input2[i]);
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < W; i++){
			bridge.add(0);
		}

        int time = 0;
        int turckIdx = 0;
        int sumWeight = 0;

        while (turckIdx < N) {
            time++;
            sumWeight -= bridge.poll();
			
            if (sumWeight + trucks[idx] <= L) { // 트럭없으면 0
                bridge.add(trucks[idx]);
                sumWeight += trucks[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        time += W;

        System.out.println(time);
    }
}
