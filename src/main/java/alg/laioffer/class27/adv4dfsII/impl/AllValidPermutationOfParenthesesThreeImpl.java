package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllValidPermutationsOfParenthesesThree;

import java.util.*;

public class AllValidPermutationOfParenthesesThreeImpl implements AllValidPermutationsOfParenthesesThree {
  private Map<Character, Integer>  store;
  private Map<Character, Integer> priority;
  private Map<Character, Character> rightToLeft;

  public AllValidPermutationOfParenthesesThreeImpl() {
    store = new HashMap<>();
    priority = new HashMap<>();
    rightToLeft = new HashMap<>();
  }
  @Override
  public List<String> validParentheses(int l, int m, int n) {
    int totalLen = 2 * (l + m + n);
    loadPriorityMap();
    loadStore(l, m, n);
    loadLeftToRight();

    List<String> res = new ArrayList<>();
    char[] sol = new char[totalLen];
    dfs(res, 0, sol, new LinkedList<Character>());
    return res;
  }

  private void dfs(List<String> res, int level, char[] sol, Deque<Character> leftStack){
    // base case
    if(level == sol.length) {
      res.add(new String(sol));
      return;
    }
    // handle addLeft
    dfsAddLeft('(', level, sol, res, leftStack);
    dfsAddLeft('<', level, sol, res, leftStack);
    dfsAddLeft('{', level, sol, res, leftStack);

    // handle addRight
    dfsAddRight(')', level, sol, res, leftStack);
    dfsAddRight('>', level, sol, res, leftStack);
    dfsAddRight('}', level, sol, res, leftStack);
  }

  private void dfsAddLeft(char bracket, int level, char[] sol, List<String> res, Deque<Character> leftStack) {
    int lastLeftOrder = leftStack.isEmpty() ? 3 : priority.get(leftStack.peek());
    if(store.get(bracket) > 0 && lastLeftOrder > priority.get(bracket)) {
      sol[level] = bracket;
      leftStack.push(bracket);
      store.put(bracket, store.get(bracket) - 1);
      dfs(res, level + 1, sol, leftStack);
      store.put(bracket, store.get(bracket) + 1);
      leftStack.pop();
    }
  }

  private void dfsAddRight(char bracket, int level, char[] sol, List<String> res, Deque<Character> leftStack) {
    if(store.get(bracket) > 0 && store.get(rightToLeft.get(bracket)) < store.get(bracket)) {
      if(!leftStack.isEmpty() && leftStack.peek() == rightToLeft.get(bracket)) {
        sol[level] = bracket;
        leftStack.pop();
        store.put(bracket, store.get(bracket) - 1);
        dfs(res, level + 1, sol, leftStack);
        store.put(bracket, store.get(bracket) + 1);
        leftStack.push(rightToLeft.get(bracket));
      }
    }
  }

  private void loadLeftToRight() {
    rightToLeft.put(')', '(');
    rightToLeft.put('>', '<');
    rightToLeft.put('}', '{');
  }
  private void loadPriorityMap() {
    priority.put('(', 0);
    priority.put('<', 1);
    priority.put('{', 2);
  }

  private void loadStore(int l, int m, int n) {
    store.put('(', l);
    store.put(')', l);
    store.put('<', m);
    store.put('>', m);
    store.put('{', n);
    store.put('}', n);
  }
}
