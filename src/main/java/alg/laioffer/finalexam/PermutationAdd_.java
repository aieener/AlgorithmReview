package alg.laioffer.finalexam;


public class PermutationAdd_ {
    public void printPer(String str) {
        if(str == null || str.length() == 0) {
            return;
        }
        char [] charArray = str.toCharArray();
        boolean [] spaces = new boolean[str.length() - 1];
        System.out.println(charArray);
        dfs(charArray, spaces, 0);
    }

    private void dfs(char [] charArray, boolean[] spaces, int start) {
        if(start == spaces.length) {
            return;
        }
        for(int i = start; i < spaces.length; i++) {
            spaces[i] = true;
            printString(charArray, spaces);
            dfs(charArray, spaces, i + 1);
            spaces[i] = false;
        }
    }

    private void printString(char [] charArray, boolean[] spaces) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < spaces.length; i++) {
            sb.append(charArray[i]);
            if(spaces[i]) {
                sb.append("_");
            }
        }
        sb.append(charArray[charArray.length - 1]);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        PermutationAdd_ pa = new PermutationAdd_();
        pa.printPer("ABC");
    }
}
