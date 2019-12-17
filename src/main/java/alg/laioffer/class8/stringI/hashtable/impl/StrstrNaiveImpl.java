package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.Strstr;

public class StrstrNaiveImpl implements Strstr {
    /*
       catcatcat
             cat
     */
    @Override
    public int strstr(String large, String small) {
        if (small == null || small.length() == 0) return 0;
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (isStrstr(large, small, i)) return i;
        }
        return -1;
    }

    private boolean isStrstr(String large, String small, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StrstrNaiveImpl().strstr("issippi", "sippi"));
    }
}
