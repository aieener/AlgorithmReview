package alg.penn.vmware;

public class Smaller {
    static String longestEvenWord(String sentence) {
        if(sentence == null || sentence.length() == 0) {
            return sentence;
        }
        int slow = 0;
        int fast = 0;
        char[] array = sentence.toCharArray();
        int globalMax = 0;
        char[] res = null;
        // It is a pleasant day today
        //    s
        //    f
        while(fast < array.length ){
            if(array[fast] != ' '){
                fast++;
            } else {
                int len = fast - slow;
                if(len % 2 == 0 && len > globalMax){
                    res = new char[len];
                    for(int i = slow; i < fast; i++){
                         res[i - slow]  = array[i];
                    }
                    globalMax  = len;
                }
                while(fast < array.length && array[fast] == ' '){
                    fast++;
                }
                slow = fast;
            }
        }
        int len = fast - slow;
        if(len % 2 == 0 && len > globalMax){
            res = new char[len];
            for(int i = slow; i < fast; i++){
                res[i - slow]  = array[i];
            }
            globalMax  = len;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Smaller sm = new Smaller();
        String input = "you can do it the way you like";
        String out = longestEvenWord(input);
        System.out.println(out);
    }
}
