import java.io.*;
import java.util.*;

public class Main {

    static int N; // 트럭 수
    static int W; // 다리길이
    static int L; // 최대 하중
    static Deque<Integer> trucks;
    static int time = 0;

    private static class Bridge {
        int maxWeight;
        int len;
        Deque<Integer> status;
        int curWeight;


        public Bridge(int n, int w, int l) {
            this.maxWeight = l;
            this.len = w;
            this.status = new ArrayDeque<>(n);
            this.curWeight = 0;

            for (int i = 0; i < this.len; i++) {
                status.addLast(0);
            }
        }

        public void addTruck(int truckWeight) {
            status.addLast(truckWeight);
            curWeight+=truckWeight;
        }

        public int removeTruck() {
            int w = status.removeFirst();
            curWeight -= w;
            return w;
        }

        public boolean addAble(int weight) {
            return this.curWeight+weight <= maxWeight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nwl = br.readLine().split(" ");
        N = Integer.parseInt(nwl[0]); // 트럭 수
        W = Integer.parseInt(nwl[1]); // 다리길이
        L = Integer.parseInt(nwl[2]); // 최대 하중
        String[] weights = br.readLine().split(" ");
        trucks = new ArrayDeque<>(N);
        for (int i = 0; i < N; i++) {
            trucks.addLast(Integer.parseInt(weights[i]));
        }

        Bridge bridge = new Bridge(N,W,L);
        while(!bridge.status.isEmpty()) {
            time++;
            bridge.removeTruck();
            //System.out.printf("%d: %d\n",time,bridge.removeTruck());
            if(!trucks.isEmpty()) {
                if(bridge.addAble(trucks.getFirst())) {
                    bridge.addTruck(trucks.removeFirst());
                } else {
                    bridge.addTruck(0);
                }
            }
        }
        System.out.println(time);
    }

}
