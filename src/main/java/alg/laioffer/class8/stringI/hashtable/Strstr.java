package alg.laioffer.class8.stringI.hashtable;

public class Strstr {
	public int strstrI(String large, String small) {
		if (large.length() < small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			if (equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}

	public boolean equals(String large, int start, String small) {
		for (int i = 0; i < small.length(); i++) {
			if (large.charAt(i + start) != small.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "bcabc";
		String small = "ab";
		Strstr str = new Strstr();
		int res = str.strstrI(input, small);
		System.out.println(res);
	}
}
