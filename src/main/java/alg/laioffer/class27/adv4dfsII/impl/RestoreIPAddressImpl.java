package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddressImpl implements RestoreIPAddress {
    /*
        There are 4 levels : 0 1 2 3
        each level, there are 3 branches
            we decide to add either one, two or three digit
            validate the result along the way
            increase the index
        when reach bottom, we and add to res
        25525511135

        Time = O(3 ^ 4)
     */
    @Override
    public List<String> Restore(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() > 12 || input.length() < 4) return res;
        char[] candidateBuf = new char[input.length() + 3];
        restore(0, 0, candidateBuf, res, input);
        return res;
    }

    private void restore(int level, int index, char[] candidate, List<String> res, String ip) {
        if (level == 3) {
            // reach bottom
            if (ip.length() - index > 3) return;
            int startIdx = index + level;
            for (; index < ip.length(); index++) {
                candidate[index + level] = ip.charAt(index);
            }
            if(validate(candidate, startIdx, index + level - 1)){
                res.add(new String(candidate));
            }
            return;
        }

        for (int partitionLen = 1; partitionLen <= 3 && ip.length() > index + partitionLen; partitionLen++) {
            for (int c = 0; c < partitionLen; c++) {
                candidate[index + c + level] = ip.charAt(index + c);
            }
            candidate[index + partitionLen + level] = '.';
            if (validate(candidate, index + level, index + level + partitionLen - 1)) {
                restore(level + 1, index + partitionLen, candidate, res, ip);
            }
        }
    }

    private boolean validate(char[] candidate, int start, int end) {
        if(end - start == 0) return true;
        else if (end - start == 1) {
            if(candidate[start] == '0') return false;
        } else if (end - start == 2){
            int intVal = 100* (candidate[start] -'0') + 10 * (candidate[start + 1] - '0') + candidate[start + 2] - '0';
            if(intVal < 100 || intVal > 255) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        RestoreIPAddress engine = new RestoreIPAddressImpl();
        System.out.println(engine.Restore("10809010").toString());
    }
}
