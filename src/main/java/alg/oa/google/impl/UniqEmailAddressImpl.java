package alg.oa.google.impl;

import java.util.HashSet;
import java.util.Set;

public class UniqEmailAddressImpl {
    private final char DOT = '.';
    private final char PLUS = '+';

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqEmails = new HashSet<>();
        for (String email : emails) {
            if (!uniqEmails.contains(email)) {
                String parsedEmail = parseEmail(email);
                uniqEmails.add(parsedEmail);
            }
        }
        return uniqEmails.size();
    }

    private String parseEmail(String email) {
        char[] input = email.toCharArray();
        // [0,.. slow) = result
        // [slow ... fast) = buffer zone;
        // [fast .. end) = unexplored
        int slow = 0;
        int fast = 0;
        for (; fast < input.length && input[fast] != '@'; fast++) {
            if (input[fast] == PLUS) {
                while (input[fast] != '@') fast++;
                fast--; // this is crucial !!
            } else if (input[fast] != DOT) {
                input[slow++] = input[fast];
            }
        }
        // cpy domain name
        for (; fast < input.length; fast++) {
            input[slow++] = input[fast];
        }
        return new String(input, 0, slow); // [0, slow)
    }
}
