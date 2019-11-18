package alg.laioffer.class23.adv1ArrayLCA;

/**
 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group
 * of elements with the same value do not keep any of them.
 * {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 */
public interface ArrayDedupFour {
  int[] dedup(int[] array);
}
