package alg.leetcode.string.impl;

import alg.leetcode.string.ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversionImpl implements ZigZagConversion {

    @Override
    public String convert(String s, int numRows) {
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) sbs.add(new StringBuilder());
        int len = s.length();
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sbs.get(idx).append(s.charAt(i++));
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sbs.get(idx).append(s.charAt(i++));
        }
        StringBuilder sbMaster = new StringBuilder();
        for (StringBuilder sb : sbs) {
            sbMaster.append(sb.toString());
        }
        return sbMaster.toString();
    }
}
