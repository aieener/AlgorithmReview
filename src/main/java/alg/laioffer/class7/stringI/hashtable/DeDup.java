package alg.laioffer.class7.stringI.hashtable;

/**
 * Linear scan, look back
 */
public class DeDup {
	public String deDup(String input) {
		if(input == null || input.length() == 0) return input;
		char[] inputArr = input.toCharArray();
		int slow = 0;
		char top = inputArr[slow];
		for (int fast = 0; fast < inputArr.length; fast++) {
			if(inputArr[fast] != inputArr[slow]) {
				slow++;
				inputArr[slow] = inputArr[fast];
			}
		}
		return new String(inputArr, 0, slow + 1);
	}
	 
	public static void main(String[] args) {
        System.out.println(new DeDup().deDup("aaabbbaaccdc"));
    }
}
