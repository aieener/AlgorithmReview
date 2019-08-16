package alg.leetcode.amazon.string.impl;

import alg.leetcode.amazon.string.PartitionLabels;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.*;

/**
 * sliding window
 * ababcbaca | defegde | hijhklij
 */
public class PartitionLabelsImpl implements PartitionLabels {
  @Override
  public List<Integer> partitionLabels(String S) {
    char[] arr= S.toCharArray();
    List<Integer> res = new ArrayList<>();
    Map<Character, Integer> record = countRecord(arr);
    int start = 0;
    while( start < arr.length) {
      // find partition
      int len = findPartition(start, arr, record );
      res.add(len);
      start += len;
    }
    return res;
  }

  private int findPartition(int start, char[] arr, Map<Character, Integer> record) {
    char startChar = arr[start];
    int count = record.get(startChar) - 1;
    int len = 1;
    Set<Character> visited = new HashSet<>();
    visited.add(startChar);
    int idx = start + 1;

    while(count > 0 && idx < arr.length ) {
      if(!visited.contains(arr[idx])) {
        count += record.get(arr[idx]);
        visited.add(arr[idx]);
      }
      count--;
      len++;
      idx++;
    }
    return len;
  }

  private Map<Character, Integer> countRecord(char[] arr) {
    Map<Character, Integer> record = new HashMap<>();
    for(Character cur: arr) {
      record.put(cur, record.getOrDefault(cur, 0) + 1);
    }
    return record;
  }

  public static void main(String[] args) {
    PartitionLabels engine = new PartitionLabelsImpl();
    String input = "ababcbacadefegdehijhklij";
    String input2 = "eaaaabaaec";
    System.out.println(engine.partitionLabels(input));
    System.out.println(engine.partitionLabels(input2));
  }
}
