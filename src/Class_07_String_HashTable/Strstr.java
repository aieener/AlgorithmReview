package Class_07_String_HashTable;

public class Strstr {
    /**
     * My Sol
     * Naive
     */
    public int strstr(String large, String small) {
        if(small.length() == 0) {
            return 0;
        }
        int len = large.length() - small.length();

        for(int i = 0; i <= len ; i++) {
            for(int j = i; j < small.length() + i; j++) {
                if(large.charAt(j) != small.charAt(j - i)){
                    break;
                }
                if(j == small.length() + i - 1){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * LaiOffer Naive Sol
     */
    public int strstrI(String large, String small) {
        if(large.length() < small.length()) {
            return -1;
        }
        if(small.length() == 0) {
            return 0;
        }
        for(int i = 0; i <= large.length() - small.length(); i++) {
            if(equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(String large, int start, String small) {
        for(int i = 0; i < small.length(); i++) {
            if(large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "bcabc";
        String small = "ab";
        Strstr str = new Strstr();
        int res = str.strstr(input,small);
        System.out.println(res);
    }

    //--- prac ---
    public int strstr2 (String large, String small) {
        if(large.length() < small.length()){
            return -1;
        }
        if(small.length() == 0) {
            return 0;
        }
        for(int i = 0; i <= large.length() - small.length(); i++) {
            if(equals2(large, i, small)){
                return i;
            }
        }
        return -1;
    }
    private boolean equals2(String large, int start, String small){
        for(int i = 0; i < small.length(); i++) {
            if(large.charAt(start + i) != small.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
