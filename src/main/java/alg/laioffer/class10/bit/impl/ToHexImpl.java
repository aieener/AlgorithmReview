package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.ToHex;

public class ToHexImpl implements ToHex {
    @Override
    public String hex(int number) {
        /*
            won't pass laiCode
         */
        if (number == 0) return "0x0";
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder("0x");
        for(int mask_end=28; mask_end >= 0; mask_end -=4) {
            char digit = base[(number >> mask_end) & 0XF];
            sb.append(digit);
        }
        return sb.toString();
    }
}
