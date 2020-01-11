package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.LargestAndSecondLargest;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargestImpl implements LargestAndSecondLargest {

    static class Element {
        int value;
        List<Integer> comparedValue;

        Element(int value) {
            this.value = value;
            this.comparedValue = new ArrayList<>();
        }
    }

    @Override
    public int[] largestAndSecond(int[] array) {
        Element[] elements = convert(array);
        int largerLen = array.length;
        while (largerLen > 1) {
            compareAndSwap(elements, largerLen);
            largerLen = (largerLen + 1) / 2;

        }
        return new int[]{elements[0].value, findLargest(elements[0].comparedValue)};
    }

    private int findLargest(List<Integer> comparedValue) {
        int res = Integer.MIN_VALUE;
        for (Integer cur : comparedValue) {
            res = Math.max(cur, res);
        }
        return res;
    }

    private void compareAndSwap(Element[] elements, int largerLen) { // put the bigger one on the left
        for (int i = 0; i < largerLen / 2; i++) {
            if (elements[i].value < elements[largerLen - i - 1].value) {
                swap(elements, i, largerLen - 1 - i);
            }
            elements[i].comparedValue.add(elements[largerLen - 1 - i].value);
        }
    }

    private void swap(Element[] elements, int left, int right) {
        Element buf = elements[left];
        elements[left] = elements[right];
        elements[right] = buf;
    }

    private Element[] convert(int[] array) {
        Element[] res = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = new Element(array[i]);
        }
        return res;
    }
}
