package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.LargestProductOfLength;

import java.util.*;

public class LargestProductOfLengthImpl implements LargestProductOfLength {

    static class Pair {
        Integer i1, i2;
        public Pair(Integer i1, Integer i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
        public Integer getProduct(String[] dict) {
            return dict[i1].length() * dict[i2].length();
        }
    }
    public int largestProduct(String[] dict) {
        // sort dict by length desc
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String base, String other){
                return other.length() - base.length();
            }
        });
        Queue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair base, Pair other) {
                return other.getProduct(dict).compareTo(base.getProduct(dict));
            }
        });
        maxHeap.offer(new Pair(0, 1));

        while(!maxHeap.isEmpty()) {
            Pair nodeToExpand = maxHeap.poll();
            int i1 = nodeToExpand.i1;
            int i2 = nodeToExpand.i2;
            if(noCommon(dict[i1], dict[i2])) return nodeToExpand.getProduct(dict);
            if(i1 + 1 < dict.length) {
                maxHeap.offer(new Pair(i1 + 1, i2));
            }
            if(i2 + 1 < dict.length){
                maxHeap.offer(new Pair(i1, i2 + 1));
            }
        }
        return 0;
    }

    private boolean noCommon(String s1, String s2) {
        Set<Character> s1Set = new HashSet<>();
        for(Character ch : s1.toCharArray()) {
            s1Set.add(ch);
        }
        for(Character ch : s2.toCharArray()) {
            if(s1Set.contains(ch)) return false;
        }
        return true;
    }
}
