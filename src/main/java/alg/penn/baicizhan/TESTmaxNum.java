package alg.penn.baicizhan;

public class TESTmaxNum {
    public Integer maxNum(String input) {
        /**
         * helloworld520helloworld1314
         *           s
         *           f
         *
         */
        char[] strArray = input.toCharArray();
        int slow = 0;
        int fast = 0;
        boolean start= false;
        StringBuilder sb = new StringBuilder();
        int resNum = -1;
        while(fast < strArray.length) {
            char curChar = strArray[fast];
            if(curChar - '0' <=  9 && curChar - '0' >= 0) {
                // chrChar is numeric
                if(start){
                    slow = fast;
                    start = false;
                }
                sb.append(curChar);
            } else  {
                if (sb.length() > 0) {
                    int curNum = Integer.valueOf(sb.toString());
                    if(curNum > resNum){
                        resNum = curNum;
                    }
                    // reset
                    start = false;
                    sb = new StringBuilder();
                }
            }
            fast++;
        }
        if(sb.length() > 0) {
            int curNum = Integer.valueOf(sb.toString());
            if(curNum > resNum){
                resNum = curNum;
            }
        }


        return resNum;
    }

    public static void main(String[] args) {
        TESTmaxNum mn = new TESTmaxNum();
        System.out.println(mn.maxNum("helloworld520helloworld1314"));
    }

}
