package alg.penn.vmware;

import java.util.*;

public class MaximumGroups {
    // similar to topological sorting
    static int maximumGroups(int[] predators) {
        Map<Integer, List<Integer>> map; // species, its predators/neighbors
        map = formMap(predators);

        // now based on the map, find the number of groups
        int res = 0;
        for(Map.Entry<Integer, List<Integer>> cur : map.entrySet()) {
            Queue<Integer> queue = new LinkedList<>();
            // stucking here...

        }

        return res;
    }

    static Map<Integer, List<Integer>> formMap(int[] predators){
        Map<Integer,List<Integer>> map = new HashMap<>();
        int i = 0;
        for(int cur : predators) {
            List<Integer> predas = new ArrayList<>();
            if(cur != -1){
                predas.add(cur);
            }
            map.put(i, predas);
            i++;
        }

        for(Map.Entry<Integer, List<Integer>> curEntry : map.entrySet()) {
            if(!curEntry.getValue().isEmpty()){
                // do bfs to find all indirect predators
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(curEntry.getValue().get(0));

                while(!queue.isEmpty()){
                    Integer curSpecie = queue.poll();
                    List<Integer> predatotors  = map.get(curSpecie);
                    for(Integer preda : predatotors) {
                        queue.offer(preda);
                        Set<Integer> set = new HashSet<>(curEntry.getValue()); // for deDup
                        if(!set.contains(preda)){
                            curEntry.getValue().add(preda);
                            set.add(preda);
                        }
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,-1,3,-1, 2, 4};
        maximumGroups(input);
    }
//        for(Map.Entry<Integer, List<Integer>> cur : map.entrySet()) {
//            System.out.print(cur.getKey()  + " is :  ");
//            System.out.print(cur.getValue());
//            System.out.println("----------------- ");
//        }
}
