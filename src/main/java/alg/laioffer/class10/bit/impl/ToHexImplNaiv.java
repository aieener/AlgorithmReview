package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.ToHex;

public class ToHexImplNaiv implements ToHex {
    @Override
    public String hex(int number) {
        if (number == 0) return "0x0";
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            int remainder = number % 16;
            number /= 16;
            sb.append(base[remainder]);
        }
        sb.append("x0");
        sb.reverse();
        return sb.toString();
    }
}
