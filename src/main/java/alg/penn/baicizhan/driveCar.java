package alg.penn.baicizhan;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by yuding on 3/24/18.
 */
public class driveCar {
    /**
     * input:
     * 4
     * 0 30 10
     * 30 40 20
     * 40 80 20
     * 80 100 5
     * 20 60
     */
    public double getDriveTime(Map<Integer[], Integer> table, int start, int end){
        PriorityQueue<Map.Entry<Integer[], Integer>> pqueue = new PriorityQueue<>(10, new Comparator<Map.Entry<Integer[], Integer>>() {
            @Override
            public int compare(Map.Entry<Integer[], Integer> t0, Map.Entry<Integer[], Integer> t1) {
                return t0.getKey()[0].compareTo(t1.getKey()[0]);
            }
        });

        for(Map.Entry<Integer[], Integer> entry : table.entrySet()){
            pqueue.offer(entry);
        }

        // now the pqueue is sorted
        Map.Entry<Integer[], Integer> startWindow = pqueue.poll();

        // find the start window
        while(!(startWindow.getKey()[0] <= start && startWindow.getKey()[1] > start)) {
            startWindow = pqueue.poll();
        }

        // startWindow found!
        double res = 0;
        if(startWindow.getKey()[1] < end) {
            res += 1.0*(startWindow.getKey()[1] - start) / startWindow.getValue();
        } else {
            res += 1.0*(end - start) / startWindow.getValue();
            return res;
        }

        Map.Entry<Integer[], Integer> nextWindow = pqueue.poll();
        while(nextWindow != null && nextWindow.getKey()[1] < end) {
            res += 1.0*(nextWindow.getKey()[1] - nextWindow.getKey()[0]) / nextWindow.getValue();
            nextWindow = pqueue.poll();
        }
        // nextWinow.getKey()[1] >= end
        res += 1.0*(end - nextWindow.getKey()[0]) / nextWindow.getValue();

        return res;
    }

    public static void main(String[] args) {
        Map<Integer[], Integer> table = new HashMap<>();
        table.put(new Integer[]{0, 30}, 10);
        table.put(new Integer[]{30, 40}, 20);
        table.put(new Integer[]{40, 80}, 20);
        table.put(new Integer[]{80, 100}, 5);
        driveCar dc = new driveCar();
        System.out.println(dc.getDriveTime(table, 30, 80));
    }
    /**
     *
     */
}
