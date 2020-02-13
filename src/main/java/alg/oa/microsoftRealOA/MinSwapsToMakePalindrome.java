package alg.oa.microsoftRealOA;

import java.util.HashMap;
import java.util.Map;

/*
ADJ swaps
Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.

Example 1:
Input: "mamad"
Output: 3

Example 2:
Input: "asflkj"
Output: -1

Example 3:
Input: "aabb"
Output: 2

Example 4:
Input: "ntiin"
Output: 1
Explanation: swap 't' with 'i' => "nitin"

sol:
Check if the string can form a palindromic permutation using https://leetcode.com/problems/palindrome-permutation/ in O(n) space mostly
Once we confirmed that it can form a palindrome, we can use 3 pointers method and return the count of characters that mismatch
 */
public class MinSwapsToMakePalindrome {
  public int minSwaps(String input) {
    if (!canFormPalindrome(input)) return -1;
    int count = 0;
    int l = 0; // [0, l) are palindrome-qualified chunk
    int r = input.length() - 1; // (r, end] are palindrome-qualified chunk
    char[] inputArr = input.toCharArray();
    while (l < r) {
      int m = r; // [l, m] are unexplored area
      while (inputArr[l] != inputArr[m] && m > l) {
        m--;
      }
      if (inputArr[l] == inputArr[m] && m > l) {
        // find an valid m:
        while (m < r) {
          swap(inputArr, m, m + 1);
          m++;
          count++;
        }
        l++;
        r--;
      } else {
        // didn't find a valid m: corner case that l is the mid single char
        swap(inputArr, l, l + 1);
        count++;
      }
    }
    return count;
  }

  private void swap(char[] input, int l, int r) {
    char temp = input[l];
    input[l] = input[r];
    input[r] = temp;
  }

  private boolean canFormPalindrome(String input) {
    Map<Character, Integer> charFreqLkup = new HashMap<>();
    // count freq
    for (Character cur : input.toCharArray()) {
      charFreqLkup.put(cur, charFreqLkup.getOrDefault(cur, 0) + 1);
    }

    // validate
    int amtOfOdd = 0;
    for (Map.Entry<Character, Integer> entry : charFreqLkup.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        amtOfOdd++;
      }
    }
    return amtOfOdd <= 1;
  }

  public static void main(String[] args) {
    MinSwapsToMakePalindrome engine = new MinSwapsToMakePalindrome();
    System.out.println(engine.minSwaps("mamad"));
    System.out.println(engine.minSwaps("asflkj"));
    System.out.println(engine.minSwaps("aabb"));
    System.out.println(engine.minSwaps("ntiin"));
  }
}
