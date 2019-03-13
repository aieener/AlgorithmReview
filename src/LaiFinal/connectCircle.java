package LaiFinal;

public class connectCircle {
//    public boolean canFormCircle(String[] input) {
//        boolean [] res = new boolean[1];
//        helper(input, 0, res);
//        return res[0];
//    }
//
//    private boolean helper(String[] input, int index, boolean[] res) {
//        if(index == input.length) {
//            return (input[index - 1].charAt(input[index - 1].length()-1) == input[0].charAt(0));
//        }
//
//        for(int i = index; i < input.length; i++) {
//            if(index == 0 || input[i].charAt(0) == input[index - 1].charAt(input[index - 1].length() - 1)) {
//                swap(input, index, i);
//                if(helper(input, index + 1, res)) {
//                    res[0] = true;
//                }
//                swap(input, index, i);
//            }
//        }
//        return false;
//    }

//    public boolean containCycle(String[] array) {
//        if (array == null || array.length == 0) {
//            return false;
//        }
//        boolean [] rst = new boolean[array.length];
//        if(array.length == 1) {
//            String s = array[0];
//            return s.charAt(0) == s.charAt(s.length() - 1);
//        }
//        return containCyclehelper(array, 1, rst);
//    }
//
//    private void swap(String[] input, int i, int j) {
//        String temp = input[i];
//        input[i] = input[j];
//        input[j] = temp;
//    }
}
