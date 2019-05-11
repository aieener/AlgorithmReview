package CIT_594;

/**
 * Yuding Ai
 * CIT 594, Recitation Feb 2 2018
 */

import java.util.*;

/**
 * 1. Implement toString method with iterator and "for each" statement respectively
 * 
 */
public class Recitation2_2{
	public static String toStringForEach(LinkedList<Integer> list) {
	    StringBuilder sb = new StringBuilder();
	    int counter = 0;
	    for(Integer cur : list) {
	        if(counter != list.size() - 1){
	            sb.append(cur.toString() + "->");
            } else {
                sb.append(cur.toString());
            }
            counter++;
        }
        // use sb.setLength(sb.size() - 1);
        return sb.toString();
	}


	public static String toStringIter(LinkedList<Integer> list) {
	    StringBuilder sb = new StringBuilder();
        Iterator<Integer> iter = list.iterator();
        int counter = 0;
        while(iter.hasNext()) {
            if(counter != list.size() - 1){
                sb.append(iter.next().toString() + "->");
            } else {
                sb.append(iter.next().toString());
            }
            counter++;
        }
        return sb.toString();
	}



/**
 * 2. Check whether the given singly linked list is palindromic or not
 * 
 */
	public static boolean isPalindrome(LinkedList<Integer> list) {
	    int len = list.size();
	    Iterator<Integer> desIter = list.descendingIterator();
        Iterator<Integer> iter = list.iterator();
        int counter = 0;
        while(iter.hasNext() && desIter.hasNext() && counter != list.size() / 2) {
            Integer left  =iter.next();
            Integer right = desIter.next();
            if(left != right) {
                return false;
            }
        }
        return true;
    }



/**
 * 3. Given a linked list, return an array that alternates between odd and even integers
 * 
 */
	public static int[] oddEvenArray(LinkedList<Integer> list) {

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int [] res = new int[list.size()];

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            Integer cur = iter.next();
            if(cur % 2 == 0) {
                //even
                even.add(cur);
            } else  {
                // odd
                odd.add(cur);
            }
        }
        int idx = 0;
        // merge even and odd
        int i = 0;
        int j = 0;
        while(i < even.size() && j < odd.size()){
            res[idx] = odd.get(i);
            i++;
            idx++;
            res[idx] = even.get(j);
            j++;
            idx++;
        }

        while(i < even.size()){
            res[idx] = even.get(i);
            j++;
            idx++;
        }

        while(i < odd.size()){
            res[idx] = odd.get(i);
            i++;
            idx++;
        }

        return res;
	}



/**
 * 4. Add the two numbers represented by two linked lists and return it as a linked list
 * 
 */
	public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> a, LinkedList<Integer> b) {
	    Iterator<Integer> desIterA = a.descendingIterator();
        Iterator<Integer> desIterB = b.descendingIterator();
        LinkedList<Integer> res = new LinkedList<>();

        Integer curDig;
        Integer carry = 0;
        while(desIterA.hasNext() && desIterB.hasNext()) {

            curDig = desIterA.next() + desIterB.next() + carry;
            if(curDig >= 10) {
                carry = curDig / 10;
                curDig = curDig % 10;
            } else {
                carry = 0;
            }
            res.addFirst(curDig);
        }
        while(desIterA.hasNext()) {
            curDig = carry + desIterA.next();
            if(curDig >= 10) {
                carry = curDig / 10;
                curDig = curDig % 10;
            } else {
                carry = 0;
            }
            res.addFirst(curDig);
        }
        while(desIterB.hasNext()) {
            curDig = carry + desIterB.next();
            if(curDig >= 10) {
                carry = curDig / 10;
                curDig = curDig % 10;
            } else {
                carry = 0;
            }
            res.addFirst(curDig);
        }
        if(carry != 0) {
            res.addFirst(carry);
        }
        return res;
	}

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>();
        input.add(4);
        System.out.println(toStringForEach(input));
        System.out.println(toStringIter(input));
        input.add(3);
        input.add(6);
        input.add(8);
        input.add(5);
        System.out.println(toStringForEach(input));
        System.out.println(toStringIter(input));

        LinkedList<Integer> input2 = new LinkedList<>();
        input2.add(1);
        input2.add(3);
        input2.add(3);
        input2.add(1);

        LinkedList<Integer> input3 = new LinkedList<>();
        input3.add(1);
        input3.add(5);
        input3.add(6);
        input3.add(5);
        input3.add(1);

        System.out.println(isPalindrome(input));
        System.out.println(isPalindrome(input2));
        System.out.println(isPalindrome(input3));


        LinkedList<Integer> input4 = new LinkedList<>();
        input4.add(1);
        input4.add(3);
        input4.add(-8);
        input4.add(2);
        input4.add(-3);
        input4.add(1);

        System.out.println(Arrays.toString(oddEvenArray(input4)));


        LinkedList<Integer> input5 = new LinkedList<>();
        input5.add(7);
        input5.add(2);
        input5.add(4);
        input5.add(3);
        LinkedList<Integer> input6 = new LinkedList<>();
        input6.add(5);
        input6.add(6);
        input6.add(4);

        System.out.println(addTwoNumbers(input5, input6));

        LinkedList<Integer> input7 = new LinkedList<>();
        input7.add(9);
        input7.add(4);
        input7.add(3);
        LinkedList<Integer> input8 = new LinkedList<>();
        input8.add(5);
        input8.add(9);
        input8.add(9);

        System.out.println(addTwoNumbers(input7, input8));

    }
}
