package Class_02_BinSearch;

public class aPowb {
    public long power(int a, int b){
        // corner case
        if(a == 1){
            return 1;
        }
        // base case
        if(b == 0){
            return 1;
        }

        return a * power(a, b - 1);
    }

    public long power2(int a, int b) {
        //special case
        if(a == 1) {
            return 1;
        }
        if(b == 0) {
            return 1;
        }
        return a * power2(a, b - 1) ;

    }

}
