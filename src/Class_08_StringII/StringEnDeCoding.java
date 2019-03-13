package Class_08_StringII;

public class StringEnDeCoding {
    // problem 1 aaaabccaaaa --> a4b1c2a5
    // similar to dedup
    /**
     * s: a[0,..s] is the output of a[0... f-1];
     * f: scan the string from left to right
     * aaaaabccbaaaa
     *  s
     *      f
     *      count =
     *
     *  step 1: replace all letters duplicated more than once
     *  left to right
     *  -> a4bc2ba4
     *  step 2: replace all letters dup only once
     *  right to left
     *  -> a4b1c2b1a4
     *      substep 1: reserve extra space
     *      substep 2: str replacement
     *          a4bc2ba4__
     *                 f
     *                   s
     *          a4b1c2b1a4
     *          f: scan the old string from right to left
     *          s: a[s+1,...new_str.length -1] is the output of
     *              a[f+1,...text.length-1]
     *
     *          if a[f] is digit or a[f+1] is digit:
     *              a[s--] = a[f--];
     *          else if a[f] is a letter not followed by dig:
     *              a[s] = '1', s--;
     *              a[s--] = a[f--]
     *
     */
}
